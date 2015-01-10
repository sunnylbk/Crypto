package com.sunnylbk.crypto

import javax.crypto.Cipher
import javax.crypto.spec.{IvParameterSpec, SecretKeySpec}

class AESCipher(key: String) extends AESAlgos {
  val ivBytes: Array[Byte] = Array('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p')

  def encrypt(mode: String, data: Array[Byte]): Array[Byte] = {
    if(!mode.equals(ECB_PKCS5) && !mode.equals(ECB) &&
      !mode.equals(CBC_PKCS5) && !mode.equals(CBC)) {
      throw new Exception("Wrong crypto mode")
    }

    val keySpec = new SecretKeySpec(key.getBytes("UTF-8"), KEY_ALGO)

    val cipher = Cipher.getInstance(mode)
    if(mode.equals(ECB_PKCS5) || mode.equals(ECB)) {
      cipher.init(Cipher.ENCRYPT_MODE, keySpec)
    }

    if(mode.equals(CBC_PKCS5) || mode.equals(CBC)){
      val iv: IvParameterSpec = new IvParameterSpec(ivBytes);
      cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv)
    }
    cipher.doFinal(data)
  }

  def decrypt(mode: String, data: Array[Byte]): Array[Byte] = {
    if(!mode.equals(ECB_PKCS5) && !mode.equals(ECB) &&
      !mode.equals(CBC_PKCS5) && !mode.equals(CBC)) {
      throw new Exception("Wrong crypto mode")
    }

    val keySpec = new SecretKeySpec(key.getBytes("UTF-8"), KEY_ALGO)

    val cipher = Cipher.getInstance(mode)

    if(mode.equals(ECB_PKCS5) || mode.equals(ECB)){
      cipher.init(Cipher.DECRYPT_MODE, keySpec)
    }

    if(mode.equals(CBC_PKCS5) || mode.equals(CBC)){
      val iv: IvParameterSpec = new IvParameterSpec(ivBytes)
      cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
    }
    cipher.doFinal(data)
  }

}

