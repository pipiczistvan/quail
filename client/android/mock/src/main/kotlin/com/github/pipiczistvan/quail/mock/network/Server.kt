package com.github.pipiczistvan.quail.mock.network

private val PRELOAD_JSON = """
{
    "availablePreviews": [
    {
        "id": 1,
        "lastModified": "2019-10-20T10:51:00Z"
    },
    {
        "id": 2,
        "lastModified": "2019-10-20T10:51:00Z"
    },
    {
        "id": 3,
        "lastModified": "2019-10-20T10:51:00Z"
    }]
}
"""

val RESPONSES = mapOf("/preload" to PRELOAD_JSON)
