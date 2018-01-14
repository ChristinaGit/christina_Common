package christina.common.data.persistance.storage.store.memory

import christina.common.data.persistance.storage.store.AbstractStoreTests
import christina.common.data.persistance.storage.store.AbstractStoreTests.Companion.Entity
import christina.common.data.persistance.storage.store.AbstractStoreTests.Companion.EntityData
import christina.common.data.presistence.storage.memory.store.MemoryAbstractStore
import java.util.function.Predicate

class MemoryAbstractStoreTests :
    AbstractStoreTests<MemoryAbstractStore<Entity, EntityData, Predicate<Entity>, Iterable<Entity>>>({
        object : MemoryAbstractStore<Entity, EntityData, Predicate<Entity>, Iterable<Entity>>(it.toMutableList()) {
            override fun applySelector(entity: Entity, selector: Predicate<Entity>): Boolean =
                selector.test(entity)

            override fun updateEntity(entity: Entity, data: EntityData): Entity =
                entity.apply {
                    name = data.name
                }

            override fun transformToQuery(entities: Iterable<Entity>): Iterable<Entity> = entities

            override fun extractEntity(entity: Entity): Entity =
                Entity(entity.id).apply {
                    name = entity.name
                }
        }
    })