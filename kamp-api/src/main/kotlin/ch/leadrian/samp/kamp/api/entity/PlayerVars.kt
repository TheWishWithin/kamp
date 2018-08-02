package ch.leadrian.samp.kamp.api.entity

import ch.leadrian.samp.kamp.api.constants.PlayerVarType

interface PlayerVars : HasPlayer {

    fun setInt(varName: String, value: Int): Boolean

    fun getInt(varName: String): Int

    fun setString(varName: String, value: String, resultLength: Int = 256): Boolean

    fun getString(varName: String): String?

    fun setFloat(varName: String, value: Float): Boolean

    fun getFloat(varName: String): Float

    fun delete(varName: String): Boolean

    val upperIndex: Int

    fun getNameAtIndex(index: Int, resultLength: Int = 256): String

    fun getType(varName: String): PlayerVarType
}