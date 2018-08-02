@file:kotlin.jvm.JvmName("BitwiseOperations")

package ch.leadrian.samp.kamp.api.util

@Suppress("NOTHING_TO_INLINE")
inline fun Int.getByte(position: Int): Int = (this shr position) and 0x0F

@Suppress("NOTHING_TO_INLINE")
inline fun Int.setByte(position: Int, value: Int): Int =
        (this and (0x0F shl position).inv()) or ((value and 0x0F) shl position)

@Suppress("NOTHING_TO_INLINE")
inline fun Int.getBit(position: Int): Int = (this shr position) and 1

@Suppress("NOTHING_TO_INLINE")
inline fun Int.setBit(position: Int, value: Int): Int =
        (this and (1 shl position).inv()) or ((value and 1) shl position)