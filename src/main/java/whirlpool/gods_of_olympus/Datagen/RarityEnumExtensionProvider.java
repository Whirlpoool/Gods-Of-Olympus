package whirlpool.gods_of_olympus.Datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import whirlpool.gods_of_olympus.Gods_of_olympus;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class RarityEnumExtensionProvider implements DataProvider {
    private final String[] GODS_FIELDS = {

    };

    private final PackOutput output;
    private final String modId;

    public RarityEnumExtensionProvider(PackOutput output) {
        this.output = output;
        this.modId = Gods_of_olympus.MODID;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        JsonObject root = new JsonObject();
        JsonArray entries = new JsonArray();


        for (String god : GODS_FIELDS) {
            entries.add(createRarityEntry(god));
        }

        root.add("entries", entries);

        // Path: src/main/resources/META-INF/enum_extensions.json
        Path path = output.getOutputFolder().resolve("META-INF/gods_of_olympus.enum_extensions.json");
        return DataProvider.saveStable(cache, root, path);
    }

    private JsonObject createRarityEntry(String fieldName) {
        JsonObject entry = new JsonObject();
        entry.addProperty("enum", "net/minecraft/world/item/Rarity");
        entry.addProperty("name", "GODS_OF_OLYMPUS_" + fieldName);
        entry.addProperty("constructor", "(ILjava/lang/String;Ljava/util/function/UnaryOperator;)V");

        JsonObject params = new JsonObject();
        params.addProperty("class", "whirlpool/gods_of_olympus/ExtendedEnums/ExtendedRarities");
        params.addProperty("field", fieldName);
        entry.add("parameters", params);

        return entry;
    }

    @Override
    public String getName() {
        return "Enum Extensions: Gods of Olympus Rarities";
    }
}
