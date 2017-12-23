package christina.common.data.persistance.storage.store.memory

import christina.common.data.persistance.storage.store.AbstractStoreTests
import christina.common.data.presistence.storage.memory.store.MemoryAbstractStore
import java.util.function.Predicate

class MemoryAbstractStoreTests :
    AbstractStoreTests({
        object : MemoryAbstractStore<Entity, EntityData, Predicate<Entity>>(generateEntities().toMutableList()) {
            override fun applySelector(entity: Entity, selector: Predicate<Entity>): Boolean =
                selector.test(entity)

            override fun updateEntity(entity: Entity, data: EntityData) {
                entity.name = data.name
            }

            override fun copyEntry(entity: Entity): Entity =
                Entity(entity.id).apply {
                    name = entity.name
                }
        }
    })