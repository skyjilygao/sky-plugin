package cn.skyjilygao.plugin.skyplugin

import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.ui.Messages

class PopupDialogAction : AnAction() {
    override fun update(e: AnActionEvent) {
        // Using the event, evaluate the context,
        // and enable or disable the action.
        val project = e.project
        e.presentation.isEnabledAndVisible = project != null
    }

    override fun actionPerformed(event: AnActionEvent) {
        // Using the event, create and show a dialog
        val currentProject = event.project
        val message =
            StringBuilder(event.presentation.text + " Selected!")
        // If an element is selected in the editor, add info about it.
        val selectedElement = event.getData(CommonDataKeys.NAVIGATABLE)
        if (selectedElement != null) {
            message.append("\nSelected Element: ").append(selectedElement)
        }
        val title = event.presentation.description
        Messages.showMessageDialog(
            currentProject,
            message.toString(),
            title,
            Messages.getInformationIcon()
        )
    }


    // Override getActionUpdateThread() when you target 2022.3 or later!
    override fun getActionUpdateThread(): ActionUpdateThread {
        return super.getActionUpdateThread()
    }
}