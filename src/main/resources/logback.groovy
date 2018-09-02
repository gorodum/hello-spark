import ch.qos.logback.classic.Level
import ch.qos.logback.classic.encoder.PatternLayoutEncoder

import java.nio.charset.Charset

def appenderList = ["CONSOLE"]
def appHost      = System.getenv("HOST")
def serviceHost  = System.getenv("SERVICE_HOST")
def appName      = System.getenv("SERVICE_NAME")  ?: "hello-spark"
def profile      = System.getenv("SPRING_PROFILES_ACTIVE")

Level rootLogLevel   = valueOf(System.getenv("LOG_LEVEL")        ?: 'INFO')
Level springLogLevel = valueOf(System.getenv("SPRING_LOG_LEVEL") ?: 'INFO')

appender("CONSOLE", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        charset = Charset.forName("UTF-8")
        pattern = '%-4relative %d %-5level [ %t ] [%mdc{X-B3-TraceId},%mdc{X-B3-SpanId}] %-55logger{13} | %m %n'
    }
}

logger('org.springframework', springLogLevel)
root(rootLogLevel, appenderList)

println '=' * 80
println """
    APP INSTANCE NAME     : $appName
    APP HOST              : $appHost
    SERVICE HOST          : $serviceHost
    APP PROFILE           : $profile
    LOGGING ROOT LEVEL    : $rootLogLevel
    LOGGING SPRING LEVEL  : $springLogLevel
    APPENDERS             : $appenderList
"""
println '=' * 80
