package christina.common.position_adapter.core.context

fun PositionContext.getLength() = getPositionEnd() - getPositionStart()

fun PositionContext.getPositionRange() = getPositionStart()..getPositionEnd()

fun PositionContext.getIndexRange() = 0..getLength()