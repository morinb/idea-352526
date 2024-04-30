package com.github.morinb

import com.github.morinb.errors.DomainError
import org.slf4j.Logger
import org.springframework.context.MessageSource
import java.time.OffsetDateTime
import java.util.*

context(Logger, DomainError)
fun toErrorApi(messageSource: MessageSource): ErrorApi {
    val key = "message.code.${code()}"
    val message = messageSource.getMessage(key, args(), "No message for key '$key'", Locale.US)

    this@Logger.error("${this@DomainError} - $message")
    val errorApi = ErrorApi().apply {
        this.code = code()
        this.message = message
        this.timestamp = OffsetDateTime.now()
    }

    return errorApi
}