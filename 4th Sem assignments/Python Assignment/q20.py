nested = {
    "fullname": "Alessandra",
    "age": 41,
    "phone-numbers": [
        "+447421234567",
        "+447423456789"
    ],
    "residence": {
        "address": {
            "first-line": "Alexandra Rd",
            "second-line": ""
        },
        "zip": "N8 0PP",
        "city": "London",
        "country": "UK"
    }
}


def flatten_json(json, starting_prefix=""):
    result = {}
    for key, value in json.items():
        if isinstance(value, dict):
            result.update(flatten_json(value, starting_prefix + key + "_"))
        else:
            result[starting_prefix + key] = value
    return result


print(flatten_json(nested))
