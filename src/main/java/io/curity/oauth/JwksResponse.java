
package io.curity.oauth;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

class JwksResponse {
	private final List<JsonWebKey> _keys;

	JwksResponse(JsonObject jsonObject) {
		JsonElement keys = jsonObject.get("keys");

		if (!keys.isJsonArray()) {
			_keys = Collections.emptyList();
		} else {
			_keys = keys.getAsJsonArray().asList().stream().filter(it -> it.isJsonObject())
					.map(JsonElement::getAsJsonObject).map(JsonWebKey::new).collect(Collectors.toList());
		}
	}

	List<JsonWebKey> getKeys() {
		return _keys;
	}
}
