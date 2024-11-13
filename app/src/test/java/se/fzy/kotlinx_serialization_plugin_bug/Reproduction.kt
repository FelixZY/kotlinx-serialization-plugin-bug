package se.fzy.kotlinx_serialization_plugin_bug

import androidx.navigation.NavDeepLink
import androidx.navigation.navDeepLink
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.junit.Assert.assertNotNull
import org.junit.Test

class Reproduction {
  @Test
  fun `MySerializableObject is not null`() {
    assertNotNull(MySerializableObject)
  }

  @Test
  fun `MySerializableObject#serializer is not null`() {
    assertNotNull(MySerializableObject.serializer())
  }
}

@Serializable
data object MySerializableObject {
  @Transient val deepLink: NavDeepLink = navDeepLink<MySerializableObject>(basePath = "Hello World")
}
