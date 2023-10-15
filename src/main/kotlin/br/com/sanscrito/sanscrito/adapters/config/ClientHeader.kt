package br.com.sanscrito.sanscrito.adapters.config

open class ClientHeader(
    var codigoUsuario: String? = null,
    var nomeUsuario: String? = null,
    var username: String? = null,
    var nomeEmpresa: String? = null,
    var codigoEmpresa: Int? = null,
    var codigoCentral: Long? = null,
    var permissoes: List<Long> = listOf(),
    var token: String? = null,
    var email: String? = null,
    var visualizaEmpresasSubordinadas: Boolean = false
)
