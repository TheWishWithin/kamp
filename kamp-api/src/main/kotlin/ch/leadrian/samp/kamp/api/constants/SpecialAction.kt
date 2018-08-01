package ch.leadrian.samp.kamp.api.constants

enum class SpecialAction(override val value: Int) : ConstantValue<Int> {
    NONE(SAMPConstants.SPECIAL_ACTION_NONE),
    DUCK(SAMPConstants.SPECIAL_ACTION_DUCK),
    USE_JETPACK(SAMPConstants.SPECIAL_ACTION_USEJETPACK),
    ENTER_VEHICLE(SAMPConstants.SPECIAL_ACTION_ENTER_VEHICLE),
    EXIT_VEHICLE(SAMPConstants.SPECIAL_ACTION_EXIT_VEHICLE),
    DANCE1(SAMPConstants.SPECIAL_ACTION_DANCE1),
    DANCE2(SAMPConstants.SPECIAL_ACTION_DANCE2),
    DANCE3(SAMPConstants.SPECIAL_ACTION_DANCE3),
    DANCE4(SAMPConstants.SPECIAL_ACTION_DANCE4),
    HANDS_UP(SAMPConstants.SPECIAL_ACTION_HANDSUP),
    USE_CELLPHONE(SAMPConstants.SPECIAL_ACTION_USECELLPHONE),
    SITTING(SAMPConstants.SPECIAL_ACTION_SITTING),
    STOP_USE_CELLPHONE(SAMPConstants.SPECIAL_ACTION_STOPUSECELLPHONE),
    DRINK_BEER(SAMPConstants.SPECIAL_ACTION_DRINK_BEER),
    SMOKE_CIGGY(SAMPConstants.SPECIAL_ACTION_SMOKE_CIGGY),
    DRINK_WINE(SAMPConstants.SPECIAL_ACTION_DRINK_WINE),
    DRINK_SPRUNK(SAMPConstants.SPECIAL_ACTION_DRINK_SPRUNK),
    CUFFED(SAMPConstants.SPECIAL_ACTION_CUFFED),
    CARRY(SAMPConstants.SPECIAL_ACTION_CARRY),
    PISSING(SAMPConstants.SPECIAL_ACTION_PISSING);

    companion object : ConstantValueRegistry<Int, SpecialAction>(*SpecialAction.values())

}