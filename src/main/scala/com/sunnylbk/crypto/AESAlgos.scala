package com.sunnylbk.crypto

trait AESAlgos {
  final val KEY_ALGO = "AES"
  final val PBE_ALGO = "PBKDF2WithHmacSHA1"

  final val ECB_PKCS5 = "AES/ECB/PKCS5Padding"
  final val ECB = "AES/ECB/NoPadding"
  final val CBC_PKCS5 = "AES/CBC/PKCS5Padding"
  final val CBC = "AES/CBC/NoPadding"
  final val GCM = "AES/GCM/NpPadding"
  final val GCM_PKCS5 = "AES/GCM/PKCS5Padding"
  final val EAX = "AES/EAX/NoPadding"
  final val EAX_PKCS5 = "AES/EAX/PKCS5Padding"
  final val CCM = "AES/CCM/NoPadding"
  final val CCM_PKCS5 = "AES/CCM/PKCS5Padding"
  final val OCB = "AES/OCB/NoPadding"
  final val OCB_PKCS5 = "AES/OCB/PKCS5Padding"
}
