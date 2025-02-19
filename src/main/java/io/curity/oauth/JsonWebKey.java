/*
 * Copyright (C) 2016 Curity AB.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.curity.oauth;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

class JsonWebKey {
	private final JsonObject _jsonObject;

	private JsonWebKeyType _keyType;

	JsonWebKey(JsonObject jsonObject) {
		_jsonObject = jsonObject;

		JsonElement jsonValue = jsonObject.get("kty");

		_keyType = JsonWebKeyType.from(jsonValue);
	}

	String getKeyId() {
		return getString("kid");
	}

	JsonWebKeyType getKeyType() {
		return _keyType;
	}

	String getUse() {
		return getString("use");
	}

	String getXCoordinate() {
		return getString("x");
	}

	String getYCoordinate() {
		return getString("y");
	}

	String getEllipticalCurve() {
		return getString("crv");
	}

	String getModulus() {
		return getString("n");
	}

	String getExponent() {
		return getString("e");
	}

	String getAlgorithm() {
		return getString("alg");
	}

	private String getString(String name) {
		return _jsonObject.get(name).getAsString();
	}
}
