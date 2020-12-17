package org.apache.daffodil.intellij.language

import com.intellij.openapi.fileTypes.{FileType, LanguageFileType}
import org.apache.daffodil.intellij.DaffodilIcon

import javax.swing.Icon

final class DfdlFileType extends LanguageFileType(DfdlLanguage) {
  def getIcon: Icon = DaffodilIcon
  def getDefaultExtension: String = DfdlFileType.DefaultExtension
  def getDescription = "DFDL"
  def getName = "DFDL"
}

object DfdlFileType {
  final val DefaultExtension = "dfdl"

  def isDfdl(fileType: FileType): Boolean = fileType match {
    case _: DfdlFileType => true
    case _ => false
  }
}
