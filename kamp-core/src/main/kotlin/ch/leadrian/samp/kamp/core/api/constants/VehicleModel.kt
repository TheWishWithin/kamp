package ch.leadrian.samp.kamp.core.api.constants

/**
 * Taken from https://github.com/Shoebill/shoebill-api
 */
enum class VehicleModel(
        override val value: Int,
        val modelName: String,
        val type: ch.leadrian.samp.kamp.core.api.constants.VehicleType,
        val numberOfSeats: Int
) : ch.leadrian.samp.kamp.core.api.constants.ConstantValue<Int> {
    LANDSTALKER(SAMPConstants.VEHICLE_LANDSTALKER, "Landstalker", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    BRAVURA(SAMPConstants.VEHICLE_BRAVURA, "Bravura", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    BUFFALO(SAMPConstants.VEHICLE_BUFFALO, "Buffalo", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    LINERUNNER(SAMPConstants.VEHICLE_LINERUNNER, "Linerunner", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    PERRENIAL(SAMPConstants.VEHICLE_PERRENIAL, "Perennial", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    SENTINEL(SAMPConstants.VEHICLE_SENTINEL, "Sentinel", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    DUMPER(SAMPConstants.VEHICLE_DUMPER, "Dumper", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 1),
    FIRETRUCK(SAMPConstants.VEHICLE_FIRETRUCK, "Firetruck", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    TRASHMASTER(SAMPConstants.VEHICLE_TRASHMASTER, "Trashmaster", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    STRETCH(SAMPConstants.VEHICLE_STRETCH, "Stretch", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    MANANA(SAMPConstants.VEHICLE_MANANA, "Manana", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    INFERNUS(SAMPConstants.VEHICLE_INFERNUS, "Infernus", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    VOODOO(SAMPConstants.VEHICLE_VOODOO, "Voodoo", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    PONY(SAMPConstants.VEHICLE_PONY, "Pony", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    MULE(SAMPConstants.VEHICLE_MULE, "Mule", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    CHEETAH(SAMPConstants.VEHICLE_CHEETAH, "Cheetah", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    AMBULANCE(SAMPConstants.VEHICLE_AMBULANCE, "Ambulance", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    LEVIATHAN(SAMPConstants.VEHICLE_LEVIATHAN, "Leviathan", ch.leadrian.samp.kamp.core.api.constants.VehicleType.HELICOPTER, 2),
    MOONBEAM(SAMPConstants.VEHICLE_MOONBEAM, "Moonbeam", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    ESPERANTO(SAMPConstants.VEHICLE_ESPERANTO, "Esperanto", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    TAXI(SAMPConstants.VEHICLE_TAXI, "Taxi", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    WASHINGTON(SAMPConstants.VEHICLE_WASHINGTON, "Washington", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    BOBCAT(SAMPConstants.VEHICLE_BOBCAT, "Bobcat", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    MRWHOOPEE(SAMPConstants.VEHICLE_MRWHOOPEE, "Mr Whoopee", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    BFINJECTION(SAMPConstants.VEHICLE_BFINJECTION, "BF Injection", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    HUNTER(SAMPConstants.VEHICLE_HUNTER, "Hunter", ch.leadrian.samp.kamp.core.api.constants.VehicleType.HELICOPTER, 1),
    PREMIER(SAMPConstants.VEHICLE_PREMIER, "Premier", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    ENFORCER(SAMPConstants.VEHICLE_ENFORCER, "Enforcer", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    SECURICAR(SAMPConstants.VEHICLE_SECURICAR, "Securicar", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    BANSHEE(SAMPConstants.VEHICLE_BANSHEE, "Banshee", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    PREDATOR(SAMPConstants.VEHICLE_PREDATOR, "Predator", ch.leadrian.samp.kamp.core.api.constants.VehicleType.BOAT, 0),
    BUS(SAMPConstants.VEHICLE_BUS, "Bus", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 8),
    RHINO(SAMPConstants.VEHICLE_RHINO, "Rhino", ch.leadrian.samp.kamp.core.api.constants.VehicleType.TANK, 1),
    BARRACKS(SAMPConstants.VEHICLE_BARRACKS, "Barracks", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    HOTKNIFE(SAMPConstants.VEHICLE_HOTKNIFE, "Hotknife", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    ARTICLETRAILER1(SAMPConstants.VEHICLE_ARTICLETRAILER1, "Trailer", ch.leadrian.samp.kamp.core.api.constants.VehicleType.TRAILER, 0),
    PREVION(SAMPConstants.VEHICLE_PREVION, "Previon", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    COACH(SAMPConstants.VEHICLE_COACH, "Coach", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 8),
    CABBIE(SAMPConstants.VEHICLE_CABBIE, "Cabbie", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    STALLION(SAMPConstants.VEHICLE_STALLION, "Stallion", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    RUMPO(SAMPConstants.VEHICLE_RUMPO, "Rumpo", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    RCBANDIT(SAMPConstants.VEHICLE_RCBANDIT, "RC Bandit", ch.leadrian.samp.kamp.core.api.constants.VehicleType.REMOTE_CONTROL, 1),
    ROMERO(SAMPConstants.VEHICLE_ROMERO, "Romero", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    PACKER(SAMPConstants.VEHICLE_PACKER, "Packer", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    MONSTER(SAMPConstants.VEHICLE_MONSTER, "Monster", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    ADMIRAL(SAMPConstants.VEHICLE_ADMIRAL, "Admiral", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    SQUALO(SAMPConstants.VEHICLE_SQUALO, "Squalo", ch.leadrian.samp.kamp.core.api.constants.VehicleType.BOAT, 0),
    SEASPARROW(SAMPConstants.VEHICLE_SEASPARROW, "Seasparrow", ch.leadrian.samp.kamp.core.api.constants.VehicleType.HELICOPTER, 2),
    PIZZABOY(SAMPConstants.VEHICLE_PIZZABOY, "Pizzaboy", ch.leadrian.samp.kamp.core.api.constants.VehicleType.MOTORBIKE, 1),
    TRAM(SAMPConstants.VEHICLE_TRAM, "Tram", ch.leadrian.samp.kamp.core.api.constants.VehicleType.TRAIN, 4),
    ARTICLETRAILER2(SAMPConstants.VEHICLE_ARTICLETRAILER2, "Trailer", ch.leadrian.samp.kamp.core.api.constants.VehicleType.TRAILER, 0),
    TURISMO(SAMPConstants.VEHICLE_TURISMO, "Turismo", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    SPEEDER(SAMPConstants.VEHICLE_SPEEDER, "Speeder", ch.leadrian.samp.kamp.core.api.constants.VehicleType.BOAT, 0),
    REEFER(SAMPConstants.VEHICLE_REEFER, "Reefer", ch.leadrian.samp.kamp.core.api.constants.VehicleType.BOAT, 0),
    TROPIC(SAMPConstants.VEHICLE_TROPIC, "Tropic", ch.leadrian.samp.kamp.core.api.constants.VehicleType.BOAT, 0),
    FLATBED(SAMPConstants.VEHICLE_FLATBED, "Flatbed", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    YANKEE(SAMPConstants.VEHICLE_YANKEE, "Yankee", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    CADDY(SAMPConstants.VEHICLE_CADDY, "Caddy", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    SOLAIR(SAMPConstants.VEHICLE_SOLAIR, "Solair", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    BERKLEYSRCVAN(SAMPConstants.VEHICLE_BERKLEYSRCVAN, "Berkleys RC Van", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    SKIMMER(SAMPConstants.VEHICLE_SKIMMER, "Skimmer", ch.leadrian.samp.kamp.core.api.constants.VehicleType.AIRCRAFT, 2),
    PCJ600(SAMPConstants.VEHICLE_PCJ600, "PCJ-600", ch.leadrian.samp.kamp.core.api.constants.VehicleType.MOTORBIKE, 2),
    FAGGIO(SAMPConstants.VEHICLE_FAGGIO, "Faggio", ch.leadrian.samp.kamp.core.api.constants.VehicleType.MOTORBIKE, 2),
    FREEWAY(SAMPConstants.VEHICLE_FREEWAY, "Freeway", ch.leadrian.samp.kamp.core.api.constants.VehicleType.MOTORBIKE, 0),
    RCBARON(SAMPConstants.VEHICLE_RCBARON, "RC Baron", ch.leadrian.samp.kamp.core.api.constants.VehicleType.REMOTE_CONTROL, 1),
    RCRAIDER(SAMPConstants.VEHICLE_RCRAIDER, "RC Raider", ch.leadrian.samp.kamp.core.api.constants.VehicleType.REMOTE_CONTROL, 1),
    GLENDALE(SAMPConstants.VEHICLE_GLENDALE, "Glendale", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    OCEANIC(SAMPConstants.VEHICLE_OCEANIC, "Oceanic", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    SANCHEZ(SAMPConstants.VEHICLE_SANCHEZ, "Sanchez", ch.leadrian.samp.kamp.core.api.constants.VehicleType.MOTORBIKE, 2),
    SPARROW(SAMPConstants.VEHICLE_SPARROW, "Sparrow", ch.leadrian.samp.kamp.core.api.constants.VehicleType.HELICOPTER, 2),
    PATRIOT(SAMPConstants.VEHICLE_PATRIOT, "Patriot", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    QUAD(SAMPConstants.VEHICLE_QUAD, "Quad", ch.leadrian.samp.kamp.core.api.constants.VehicleType.MOTORBIKE, 2),
    COASTGUARD(SAMPConstants.VEHICLE_COASTGUARD, "Coastguard", ch.leadrian.samp.kamp.core.api.constants.VehicleType.BOAT, 0),
    DINGHY(SAMPConstants.VEHICLE_DINGHY, "Dinghy", ch.leadrian.samp.kamp.core.api.constants.VehicleType.BOAT, 0),
    HERMES(SAMPConstants.VEHICLE_HERMES, "Hermes", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    SABRE(SAMPConstants.VEHICLE_SABRE, "Sabre", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    RUSTLER(SAMPConstants.VEHICLE_RUSTLER, "Rustler", ch.leadrian.samp.kamp.core.api.constants.VehicleType.AIRCRAFT, 1),
    ZR350(SAMPConstants.VEHICLE_ZR350, "ZR3 50", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    WALTON(SAMPConstants.VEHICLE_WALTON, "Walton", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    REGINA(SAMPConstants.VEHICLE_REGINA, "Regina", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    COMET(SAMPConstants.VEHICLE_COMET, "Comet", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    BMX(SAMPConstants.VEHICLE_BMX, "BMX", ch.leadrian.samp.kamp.core.api.constants.VehicleType.BICYCLE, 1),
    BURRITO(SAMPConstants.VEHICLE_BURRITO, "Burrito", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    CAMPER(SAMPConstants.VEHICLE_CAMPER, "Camper", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 3),
    MARQUIS(SAMPConstants.VEHICLE_MARQUIS, "Marquis", ch.leadrian.samp.kamp.core.api.constants.VehicleType.BOAT, 0),
    BAGGAGE(SAMPConstants.VEHICLE_BAGGAGE, "Baggage", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 1),
    DOZER(SAMPConstants.VEHICLE_DOZER, "Dozer", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 1),
    MAVERICK(SAMPConstants.VEHICLE_MAVERICK, "Maverick", ch.leadrian.samp.kamp.core.api.constants.VehicleType.HELICOPTER, 4),
    SANNEWSMAVERICK(SAMPConstants.VEHICLE_SANNEWSMAVERICK, "News Chopper", ch.leadrian.samp.kamp.core.api.constants.VehicleType.HELICOPTER, 2),
    RANCHER(SAMPConstants.VEHICLE_RANCHER, "Rancher", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    FBIRANCHER(SAMPConstants.VEHICLE_FBIRANCHER, "FBI Rancher", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    VIRGO(SAMPConstants.VEHICLE_VIRGO, "Virgo", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    GREENWOOD(SAMPConstants.VEHICLE_GREENWOOD, "Greenwood", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    JETMAX(SAMPConstants.VEHICLE_JETMAX, "Jetmax", ch.leadrian.samp.kamp.core.api.constants.VehicleType.BOAT, 0),
    HOTRINGRACER(SAMPConstants.VEHICLE_HOTRINGRACER, "Hotring", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    SANDKING(SAMPConstants.VEHICLE_SANDKING, "Sandking", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    BLISTACOMPACT(SAMPConstants.VEHICLE_BLISTACOMPACT, "Blista Compact", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    POLICEMAVERICK(SAMPConstants.VEHICLE_POLICEMAVERICK, "Police Maverick", ch.leadrian.samp.kamp.core.api.constants.VehicleType.HELICOPTER, 4),
    BOXVILLE(SAMPConstants.VEHICLE_BOXVILLE, "Boxville", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    BENSON(SAMPConstants.VEHICLE_BENSON, "Benson", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    MESA(SAMPConstants.VEHICLE_MESA, "Mesa", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    RCGOBLIN(SAMPConstants.VEHICLE_RCGOBLIN, "RC Goblin", ch.leadrian.samp.kamp.core.api.constants.VehicleType.REMOTE_CONTROL, 1),
    HOTRINGRACERA(SAMPConstants.VEHICLE_HOTRINGRACERA, "Hotring Racer", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    HOTRINGRACERB(SAMPConstants.VEHICLE_HOTRINGRACERB, "Hotring Racer", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    BLOODRINGBANGER(SAMPConstants.VEHICLE_BLOODRINGBANGER, "Bloodring Banger", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    RANCHERLURE(SAMPConstants.VEHICLE_RANCHERLURE, "Rancher", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    SUPERGT(SAMPConstants.VEHICLE_SUPERGT, "Super GT", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    ELEGANT(SAMPConstants.VEHICLE_ELEGANT, "Elegant", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    JOURNEY(SAMPConstants.VEHICLE_JOURNEY, "Journey", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    BIKE(SAMPConstants.VEHICLE_BIKE, "Bike", ch.leadrian.samp.kamp.core.api.constants.VehicleType.BICYCLE, 1),
    MOUNTAINBIKE(SAMPConstants.VEHICLE_MOUNTAINBIKE, "Mountain Bike", ch.leadrian.samp.kamp.core.api.constants.VehicleType.BICYCLE, 1),
    BEAGLE(SAMPConstants.VEHICLE_BEAGLE, "Beagle", ch.leadrian.samp.kamp.core.api.constants.VehicleType.AIRCRAFT, 2),
    CROPDUST(SAMPConstants.VEHICLE_CROPDUST, "Cropdust", ch.leadrian.samp.kamp.core.api.constants.VehicleType.AIRCRAFT, 1),
    STUNTPLANE(SAMPConstants.VEHICLE_STUNTPLANE, "Stunt", ch.leadrian.samp.kamp.core.api.constants.VehicleType.AIRCRAFT, 1),
    TANKER(SAMPConstants.VEHICLE_TANKER, "Tanker", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    ROADTRAIN(SAMPConstants.VEHICLE_ROADTRAIN, "RoadTrain", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    NEBULA(SAMPConstants.VEHICLE_NEBULA, "Nebula", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    MAJESTIC(SAMPConstants.VEHICLE_MAJESTIC, "Majestic", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    BUCCANEER(SAMPConstants.VEHICLE_BUCCANEER, "Buccaneer", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    SHAMAL(SAMPConstants.VEHICLE_SHAMAL, "Shamal", ch.leadrian.samp.kamp.core.api.constants.VehicleType.AIRCRAFT, 1),
    HYDRA(SAMPConstants.VEHICLE_HYDRA, "Hydra", ch.leadrian.samp.kamp.core.api.constants.VehicleType.AIRCRAFT, 1),
    FCR900(SAMPConstants.VEHICLE_FCR900, "FCR-900", ch.leadrian.samp.kamp.core.api.constants.VehicleType.MOTORBIKE, 2),
    NRG500(SAMPConstants.VEHICLE_NRG500, "NRG-500", ch.leadrian.samp.kamp.core.api.constants.VehicleType.MOTORBIKE, 2),
    HPV1000(SAMPConstants.VEHICLE_HPV1000, "HPV1000", ch.leadrian.samp.kamp.core.api.constants.VehicleType.MOTORBIKE, 2),
    CEMENTTRUCK(SAMPConstants.VEHICLE_CEMENTTRUCK, "Cement Truck", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    TOWTRUCK(SAMPConstants.VEHICLE_TOWTRUCK, "Tow Truck", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    FORTUNE(SAMPConstants.VEHICLE_FORTUNE, "Fortune", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    CADRONA(SAMPConstants.VEHICLE_CADRONA, "Cadrona", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    FBITRUCK(SAMPConstants.VEHICLE_FBITRUCK, "FBI Truck", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    WILLARD(SAMPConstants.VEHICLE_WILLARD, "Willard", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    FORKLIFT(SAMPConstants.VEHICLE_FORKLIFT, "Forklift", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 1),
    TRACTOR(SAMPConstants.VEHICLE_TRACTOR, "Tractor", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 1),
    COMBINE(SAMPConstants.VEHICLE_COMBINE, "Combine", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 1),
    FELTZER(SAMPConstants.VEHICLE_FELTZER, "Feltzer", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    REMINGTON(SAMPConstants.VEHICLE_REMINGTON, "Remington", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    SLAMVAN(SAMPConstants.VEHICLE_SLAMVAN, "Slamvan", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    BLADE(SAMPConstants.VEHICLE_BLADE, "Blade", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    FREIGHT(SAMPConstants.VEHICLE_FREIGHT, "Freight", ch.leadrian.samp.kamp.core.api.constants.VehicleType.TRAIN, 2),
    BROWNSTREAK(SAMPConstants.VEHICLE_BROWNSTREAK, "Streak", ch.leadrian.samp.kamp.core.api.constants.VehicleType.TRAIN, 2),
    VORTEX(SAMPConstants.VEHICLE_VORTEX, "Vortex", ch.leadrian.samp.kamp.core.api.constants.VehicleType.BOAT, 0),
    VINCENT(SAMPConstants.VEHICLE_VINCENT, "Vincent", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    BULLET(SAMPConstants.VEHICLE_BULLET, "Bullet", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    CLOVER(SAMPConstants.VEHICLE_CLOVER, "Clover", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    SADLER(SAMPConstants.VEHICLE_SADLER, "Sadler", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    FIRETRUCKLA(SAMPConstants.VEHICLE_FIRETRUCKLA, "Firetruck", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    HUSTLER(SAMPConstants.VEHICLE_HUSTLER, "Hustler", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    INTRUDER(SAMPConstants.VEHICLE_INTRUDER, "Intruder", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    PRIMO(SAMPConstants.VEHICLE_PRIMO, "Primo", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    CARGOBOB(SAMPConstants.VEHICLE_CARGOBOB, "Cargobob", ch.leadrian.samp.kamp.core.api.constants.VehicleType.HELICOPTER, 2),
    TAMPA(SAMPConstants.VEHICLE_TAMPA, "Tampa", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    SUNRISE(SAMPConstants.VEHICLE_SUNRISE, "Sunrise", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    MERIT(SAMPConstants.VEHICLE_MERIT, "Merit", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    UTILITYVAN(SAMPConstants.VEHICLE_UTILITYVAN, "Utility", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    NEVADA(SAMPConstants.VEHICLE_NEVADA, "Nevada", ch.leadrian.samp.kamp.core.api.constants.VehicleType.AIRCRAFT, 1),
    YOSEMITE(SAMPConstants.VEHICLE_YOSEMITE, "Yosemite", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    WINDSOR(SAMPConstants.VEHICLE_WINDSOR, "Windsor", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    MONSTERA(SAMPConstants.VEHICLE_MONSTERA, "Monster", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    MONSTERB(SAMPConstants.VEHICLE_MONSTERB, "Monster", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    URANUS(SAMPConstants.VEHICLE_URANUS, "Uranus", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    JESTER(SAMPConstants.VEHICLE_JESTER, "Jester", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    SULTAN(SAMPConstants.VEHICLE_SULTAN, "Sultan", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    STRATUM(SAMPConstants.VEHICLE_STRATUM, "Stratum", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    ELEGY(SAMPConstants.VEHICLE_ELEGY, "Elegy", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    RAINDANCE(SAMPConstants.VEHICLE_RAINDANCE, "Raindance", ch.leadrian.samp.kamp.core.api.constants.VehicleType.HELICOPTER, 2),
    RCTIGER(SAMPConstants.VEHICLE_RCTIGER, "RC Tiger", ch.leadrian.samp.kamp.core.api.constants.VehicleType.REMOTE_CONTROL, 1),
    FLASH(SAMPConstants.VEHICLE_FLASH, "Flash", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    TAHOMA(SAMPConstants.VEHICLE_TAHOMA, "Tahoma", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    SAVANNA(SAMPConstants.VEHICLE_SAVANNA, "Savanna", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    BANDITO(SAMPConstants.VEHICLE_BANDITO, "Bandito", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 1),
    FREIGHTFLATTRAILER(SAMPConstants.VEHICLE_FREIGHTFLATTRAILER, "Freight", ch.leadrian.samp.kamp.core.api.constants.VehicleType.TRAIN, 0),
    STREAKTRAILER(SAMPConstants.VEHICLE_STREAKTRAILER, "Trailer", ch.leadrian.samp.kamp.core.api.constants.VehicleType.TRAIN, 0),
    KART(SAMPConstants.VEHICLE_KART, "Kart", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 1),
    MOWER(SAMPConstants.VEHICLE_MOWER, "Mower", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 1),
    DUNERIDE(SAMPConstants.VEHICLE_DUNERIDE, "Duneride", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    SWEEPER(SAMPConstants.VEHICLE_SWEEPER, "Sweeper", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 1),
    BROADWAY(SAMPConstants.VEHICLE_BROADWAY, "Broadway", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    TORNADO(SAMPConstants.VEHICLE_TORNADO, "Tornado", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    AT400(SAMPConstants.VEHICLE_AT400, "AT-400", ch.leadrian.samp.kamp.core.api.constants.VehicleType.AIRCRAFT, 1),
    DFT30(SAMPConstants.VEHICLE_DFT30, "DFT-30", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    HUNTLEY(SAMPConstants.VEHICLE_HUNTLEY, "Huntley", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    STAFFORD(SAMPConstants.VEHICLE_STAFFORD, "Stafford", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    BF400(SAMPConstants.VEHICLE_BF400, "BF-400", ch.leadrian.samp.kamp.core.api.constants.VehicleType.MOTORBIKE, 2),
    NEWSVAN(SAMPConstants.VEHICLE_NEWSVAN, "Newsvan", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    TUG(SAMPConstants.VEHICLE_TUG, "Tug", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 1),
    PETROLTRAILER(SAMPConstants.VEHICLE_PETROLTRAILER, "Trailer", ch.leadrian.samp.kamp.core.api.constants.VehicleType.TRAILER, 0),
    EMPEROR(SAMPConstants.VEHICLE_EMPEROR, "Emperor", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    WAYFARER(SAMPConstants.VEHICLE_WAYFARER, "Wayfarer", ch.leadrian.samp.kamp.core.api.constants.VehicleType.MOTORBIKE, 2),
    EUROS(SAMPConstants.VEHICLE_EUROS, "Euros", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    HOTDOG(SAMPConstants.VEHICLE_HOTDOG, "Hotdog", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    CLUB(SAMPConstants.VEHICLE_CLUB, "Club", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    FREIGHTBOXTRAILER(SAMPConstants.VEHICLE_FREIGHTBOXTRAILER, "Trailer", ch.leadrian.samp.kamp.core.api.constants.VehicleType.TRAILER, 0),
    ARTICLETRAILER3(SAMPConstants.VEHICLE_ARTICLETRAILER3, "Trailer", ch.leadrian.samp.kamp.core.api.constants.VehicleType.TRAILER, 0),
    ANDROMADA(SAMPConstants.VEHICLE_ANDROMADA, "Andromada", ch.leadrian.samp.kamp.core.api.constants.VehicleType.AIRCRAFT, 2),
    DODO(SAMPConstants.VEHICLE_DODO, "Dodo", ch.leadrian.samp.kamp.core.api.constants.VehicleType.AIRCRAFT, 2),
    RCCAM(SAMPConstants.VEHICLE_RCCAM, "RC Cam", ch.leadrian.samp.kamp.core.api.constants.VehicleType.REMOTE_CONTROL, 1),
    LAUNCH(SAMPConstants.VEHICLE_LAUNCH, "Launch", ch.leadrian.samp.kamp.core.api.constants.VehicleType.BOAT, 0),
    POLICECARLSPD(SAMPConstants.VEHICLE_POLICECARLSPD, "Police Car LSPD", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    POLICECARSFPD(SAMPConstants.VEHICLE_POLICECARSFPD, "Police Car SFPD", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    POLICECARLVPD(SAMPConstants.VEHICLE_POLICECARLVPD, "Police Car LVPD", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    POLICERANGER(SAMPConstants.VEHICLE_POLICERANGER, "Police Ranger", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    PICADOR(SAMPConstants.VEHICLE_PICADOR, "Picador", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    SWAT(SAMPConstants.VEHICLE_SWAT, "SWAT Van", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    ALPHA(SAMPConstants.VEHICLE_ALPHA, "Alpha", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    PHOENIX(SAMPConstants.VEHICLE_PHOENIX, "Phoenix", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    GLENDALESHIT(SAMPConstants.VEHICLE_GLENDALESHIT, "Glendale", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    SADLERSHIT(SAMPConstants.VEHICLE_SADLERSHIT, "Sadler", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 2),
    BAGGAGETRAILERA(SAMPConstants.VEHICLE_BAGGAGETRAILERA, "Luggage Trailer", ch.leadrian.samp.kamp.core.api.constants.VehicleType.TRAILER, 0),
    BAGGAGETRAILERB(SAMPConstants.VEHICLE_BAGGAGETRAILERB, "Luggage Trailer", ch.leadrian.samp.kamp.core.api.constants.VehicleType.TRAILER, 0),
    TUGSTAIRSTRAILER(SAMPConstants.VEHICLE_TUGSTAIRSTRAILER, "Stair Trailer", ch.leadrian.samp.kamp.core.api.constants.VehicleType.TRAILER, 0),
    BOXBURG(SAMPConstants.VEHICLE_BOXBURG, "Boxville", ch.leadrian.samp.kamp.core.api.constants.VehicleType.CAR, 4),
    FARMTRAILER(SAMPConstants.VEHICLE_FARMTRAILER, "Farm Plow", ch.leadrian.samp.kamp.core.api.constants.VehicleType.TRAILER, 0),
    UTILITYTRAILER(SAMPConstants.VEHICLE_UTILITYTRAILER, "Utility Trailer", ch.leadrian.samp.kamp.core.api.constants.VehicleType.TRAILER, 0);

    companion object : ch.leadrian.samp.kamp.core.api.constants.ConstantValueRegistry<Int, VehicleModel>(*VehicleModel.values())

}
