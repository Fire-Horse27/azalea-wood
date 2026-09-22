package fire_horse27.azaleawood.util;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.minecraft.world.entity.vehicle.boat.ChestRaft;
import net.minecraft.world.entity.vehicle.boat.Raft;
import net.minecraft.world.item.Item;
import org.jspecify.annotations.Nullable;

/*
 * Original code by gniftygnome, used under GPLv3.
 * Licensed under the GNU General Public License v3.0
 * Modified by Fire_Horse27 – variable names adjusted.
 */

public record TerraformCpyBoatDataImpl(Identifier id, @Nullable EntityType<Boat> boatEntityType, @Nullable EntityType<ChestBoat> chestBoatEntityType, @Nullable EntityType<Raft> raftEntityType, @Nullable EntityType<ChestRaft> chestRaftEntityType) implements TerraformCpyBoatData {
    private static final Map<Identifier, TerraformCpyBoatDataImpl> BOAT_DATA = new ConcurrentHashMap<>();

    public TerraformCpyBoatDataImpl {
        Objects.requireNonNull(id);
    }


    public static void put(TerraformCpyBoatDataImpl boatData) {
        BOAT_DATA.put(boatData.id, boatData);
    }

    public static TerraformCpyBoatDataImpl get(Identifier id) {
        Objects.requireNonNull(id);
        if (!BOAT_DATA.containsKey(id)) {
            throw new RuntimeException("Request for unregistered boat data: " + id);
        }

        return BOAT_DATA.get(id);
    }

    public static Optional<TerraformCpyBoatDataImpl> getOptional(@Nullable Identifier id) {
        if (id == null || !BOAT_DATA.containsKey(id)) {
            return Optional.empty();
        }

        return Optional.of(BOAT_DATA.get(id));
    }


    public static TerraformCpyBoatDataImpl empty(Identifier id) {
        return new TerraformCpyBoatDataImpl(id, null, null, null, null);
    }

    public static void addBoat(Identifier id, EntityType<Boat> boatEntity) {
        if (BOAT_DATA.containsKey(id)) {
            TerraformCpyBoatDataImpl old = BOAT_DATA.get(id);
            if (old.boatEntityType != null) {
                throw new IllegalStateException("Attempted to replace existing boat entity: " + old.boatId());
            }
            put(new TerraformCpyBoatDataImpl(id, boatEntity, old.chestBoatEntityType, old.raftEntityType, old.chestRaftEntityType));
        } else {
            put(new TerraformCpyBoatDataImpl(id, boatEntity, null, null, null));
        }
    }

    public static void addChestBoat(Identifier id, EntityType<ChestBoat> chestBoatEntity) {
        if (BOAT_DATA.containsKey(id)) {
            TerraformCpyBoatDataImpl old = BOAT_DATA.get(id);
            if (old.chestBoatEntityType != null) {
                throw new IllegalStateException("Attempted to replace existing chest boat entity: " + old.chestBoatId());
            }
            put(new TerraformCpyBoatDataImpl(id, old.boatEntityType, chestBoatEntity, old.raftEntityType, old.chestRaftEntityType));
        } else {
            put(new TerraformCpyBoatDataImpl(id, null, chestBoatEntity, null, null));
        }
    }

    public static void addRaft(Identifier id, EntityType<Raft> raftEntity) {
        if (BOAT_DATA.containsKey(id)) {
            TerraformCpyBoatDataImpl old = BOAT_DATA.get(id);
            if (old.raftEntityType != null) {
                throw new IllegalStateException("Attempted to replace existing raft entity: " + old.raftId());
            }
            put(new TerraformCpyBoatDataImpl(id, old.boatEntityType, old.chestBoatEntityType, raftEntity, old.chestRaftEntityType));
        } else {
            put(new TerraformCpyBoatDataImpl(id, null, null, raftEntity, null));
        }
    }

    public static void addChestRaft(Identifier id, EntityType<ChestRaft> chestRaftEntity) {
        if (BOAT_DATA.containsKey(id)) {
            TerraformCpyBoatDataImpl old = BOAT_DATA.get(id);
            if (old.chestRaftEntityType != null) {
                throw new IllegalStateException("Attempted to replace existing chest raft entity: " + old.chestRaftId());
            }
            put(new TerraformCpyBoatDataImpl(id, old.boatEntityType, old.chestBoatEntityType, old.raftEntityType, chestRaftEntity));
        } else {
            put(new TerraformCpyBoatDataImpl(id, null, null, null, chestRaftEntity));
        }
    }


    @Override
    public Identifier boatId() {
        return id.withSuffix("_boat");
    }

    @Override
    public Identifier chestBoatId() {
        return id.withSuffix("_chest_boat");
    }

    @Override
    public ResourceKey<Item> boatKey() {
        return ResourceKey.create(Registries.ITEM, boatId());
    }

    @Override
    public ResourceKey<Item> chestBoatKey() {
        return ResourceKey.create(Registries.ITEM, chestBoatId());
    }

    @Override
    public Identifier boatEntityTypeId() {
        return boatId();
    }

    @Override
    public Identifier chestBoatEntityTypeId() {
        return chestBoatId();
    }

    @Override
    public ResourceKey<EntityType<?>> boatEntityTypeKey() {
        return ResourceKey.create(Registries.ENTITY_TYPE, boatEntityTypeId());
    }

    @Override
    public ResourceKey<EntityType<?>> chestBoatEntityTypeKey() {
        return ResourceKey.create(Registries.ENTITY_TYPE, chestBoatEntityTypeId());
    }

    @Override
    public Identifier boatModelLayerId() {
        return id.withPrefix("boat/");
    }

    @Override
    public Identifier chestBoatModelLayerId() {
        return id.withPrefix("chest_boat/");
    }

    @Override
    public Identifier raftId() {
        return id.withSuffix("_raft");
    }

    @Override
    public Identifier chestRaftId() {
        return id.withSuffix("_chest_raft");
    }

    @Override
    public ResourceKey<Item> raftKey() {
        return ResourceKey.create(Registries.ITEM, raftId());
    }

    @Override
    public ResourceKey<Item> chestRaftKey() {
        return ResourceKey.create(Registries.ITEM, chestRaftId());
    }

    @Override
    public Identifier raftEntityTypeId() {
        return raftId();
    }

    @Override
    public Identifier chestRaftEntityTypeId() {
        return chestRaftId();
    }

    @Override
    public ResourceKey<EntityType<?>> raftEntityTypeKey() {
        return ResourceKey.create(Registries.ENTITY_TYPE, raftEntityTypeId());
    }

    @Override
    public ResourceKey<EntityType<?>> chestRaftEntityTypeKey() {
        return ResourceKey.create(Registries.ENTITY_TYPE, chestRaftEntityTypeId());
    }

    @Override
    public Identifier raftModelLayerId() {
        return id.withPrefix("raft/");
    }

    @Override
    public Identifier chestRaftModelLayerId() {
        return id.withPrefix("chest_raft/");
    }
}

