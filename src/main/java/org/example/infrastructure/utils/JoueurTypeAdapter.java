package org.example.infrastructure.utils;

import com.google.gson.*;
import org.example.domain.models.Guerrier;
import org.example.domain.models.Joueur;
import org.example.domain.models.Mage;
import org.example.domain.models.Voleur;

import java.lang.reflect.Type;

public class JoueurTypeAdapter implements JsonDeserializer<Joueur>, JsonSerializer<Joueur> {

    @Override
    public JsonElement serialize(Joueur joueur, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = context.serialize(joueur).getAsJsonObject();
        jsonObject.addProperty("type", joueur.getType());
        return jsonObject;
    }

    @Override
    public Joueur deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        if (!jsonObject.has("type")) {
            throw new JsonParseException("Le champ 'type' est manquant dans le JSON !");
        }

        String type = jsonObject.get("type").getAsString();


        switch (type) {
            case "Guerrier":
                return context.deserialize(jsonObject, Guerrier.class);
            case "Mage":
                return context.deserialize(jsonObject, Mage.class);
            case "Voleur":
                return context.deserialize(jsonObject, Voleur.class);
            default:
                throw new JsonParseException("Type inconnu : " + type);
        }
    }
}
