package com.example.reply.ui

import com.example.reply.data.Email
import com.example.reply.data.MailboxType
import com.example.reply.data.local.LocalEmailsDataProvider

/**
 * Data class that represents current UI State
 */
data class ReplyUiState(
    /** Emails map for all type of [MailboxType] **/
    val mailboxes: Map<MailboxType, List<Email>> = emptyMap(),
    /** Current mailbox being displayed **/
    val currentMailbox: MailboxType = MailboxType.Inbox,
    /** Current selected email for the mailbox being displayed **/
    val currentSelectedEmail: Email = LocalEmailsDataProvider.defaultEmail,
    /** Whether currently displaying homepage **/
    val isShowingHomepage: Boolean = true
) {
    /** Current list of emails for the mailbox being displayed **/
    val currentMailboxEmails: List<Email> by lazy { mailboxes[currentMailbox]!! }
}
