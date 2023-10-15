package br.com.sanscrito.sanscrito.adapters.config

import org.springframework.http.HttpHeaders
import org.springframework.web.servlet.HandlerInterceptor
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class ClientInterceptor(clientEntity: ClientHeader) : HandlerInterceptor {
    private val clientHeader: ClientHeader

    init {
        this.clientHeader = clientEntity
    }

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        clientHeader.codigoUsuario = request.getHeader("codigo_usuario")
        clientHeader.nomeUsuario = request.getHeader("nome_usuario")
        clientHeader.username = request.getHeader("username")
        clientHeader.token = request.getHeader(HttpHeaders.AUTHORIZATION)
        clientHeader.codigoCentral = request.getHeader("codigo_central")?.toLongOrNull()
        clientHeader.codigoEmpresa = request.getHeader("codigo_softfocus")?.toIntOrNull()
        clientHeader.nomeEmpresa = request.getHeader("cooperativa")
        clientHeader.permissoes = request.getHeader("permissoes")?.split(",")?.mapNotNull {
            it.trim().toLongOrNull()
        } ?: listOf()
        clientHeader.email = request.getHeader("email")
        clientHeader.visualizaEmpresasSubordinadas =
            request.getHeader("visualizaEmpresasSubordinadas")?.toBoolean() == true
        return clientHeader.codigoUsuario != null
    }
}
