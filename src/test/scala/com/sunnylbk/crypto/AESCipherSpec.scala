package com.sunnylbk.crypto

import org.scalatest.FlatSpec

class AESCipherSpec extends FlatSpec with AESAlgos {
  val key = "ThisIsASecretKey"
  def withPaddingtest(mode: String) = {
    val sampleInput = "sample text"
    "AES" should s"encrypt/decrypt successfully with ${mode} mode" in {
      val cipher = new AESCipher(key)
      val encrypted = cipher.encrypt(mode, sampleInput.getBytes("UTF-8"))
      val decrypted = cipher.decrypt(mode, encrypted)
      assert(new String(decrypted, "UTF-8") == sampleInput)
    }
  }

  def noPaddingTest(mode: String) = {
    val sampleInput = "some sample text" // size should be multiple of 16
    "AES" should s"encrypt/decrypt successfully with ${mode} mode" in {
      val cipher = new AESCipher(key)
      val encrypted = cipher.encrypt(mode, sampleInput.getBytes("UTF-8"))
      val decrypted = cipher.decrypt(mode, encrypted)
      assert(new String(decrypted, "UTF-8") == sampleInput)
    }
  }

  withPaddingtest(CBC_PKCS5)
  noPaddingTest(CBC)
  withPaddingtest(ECB_PKCS5)
  noPaddingTest(ECB)
}
