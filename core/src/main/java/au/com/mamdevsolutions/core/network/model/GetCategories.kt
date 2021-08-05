package au.com.mamdevsolutions.core.network.model

data class GetCategories(
    val baseurl: String,
    val contents: Contents,
    val copyright: Copyright,
    val success: Success
)