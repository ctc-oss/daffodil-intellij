package org.apache.daffodil.intellij.highlight

import com.intellij.ide.highlighter.XmlFileHighlighter
import com.intellij.openapi.fileTypes.{SyntaxHighlighter, SyntaxHighlighterFactory}
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

class DfdlSyntaxHighlighterFactory extends SyntaxHighlighterFactory {
  def getSyntaxHighlighter(project: Project, virtualFile: VirtualFile): SyntaxHighlighter = DfdlSyntaxHighlighter
}

object DfdlSyntaxHighlighter extends XmlFileHighlighter
