package ch.leadrian.samp.kamp.api.constants

enum class VehicleModel(
        override val value: Int,
        val modelName: String,
        val type: VehicleType,
        val numberOfSeats: Int
) : ConstantValue<Int> {
    LANDSTALKER(SAMPConstants.VEHICLE_LANDSTALKER, "Landstalker", VehicleType.CAR, 4),
    BRAVURA(SAMPConstants.VEHICLE_BRAVURA, "Bravura", VehicleType.CAR, 2),
    BUFFALO(SAMPConstants.VEHICLE_BUFFALO, "Buffalo", VehicleType.CAR, 2),
    LINERUNNER(SAMPConstants.VEHICLE_LINERUNNER, "Linerunner", VehicleType.CAR, 2),
    PERRENIAL(SAMPConstants.VEHICLE_PERRENIAL, "Perennial", VehicleType.CAR, 4),
    SENTINEL(SAMPConstants.VEHICLE_SENTINEL, "Sentinel", VehicleType.CAR, 4),
    DUMPER(SAMPConstants.VEHICLE_DUMPER, "Dumper", VehicleType.CAR, 1),
    FIRETRUCK(SAMPConstants.VEHICLE_FIRETRUCK, "Firetruck", VehicleType.CAR, 2),
    TRASHMASTER(SAMPConstants.VEHICLE_TRASHMASTER, "Trashmaster", VehicleType.CAR, 2),
    STRETCH(SAMPConstants.VEHICLE_STRETCH, "Stretch", VehicleType.CAR, 4),
    MANANA(SAMPConstants.VEHICLE_MANANA, "Manana", VehicleType.CAR, 2),
    INFERNUS(SAMPConstants.VEHICLE_INFERNUS, "Infernus", VehicleType.CAR, 2),
    VOODOO(SAMPConstants.VEHICLE_VOODOO, "Voodoo", VehicleType.CAR, 2),
    PONY(SAMPConstants.VEHICLE_PONY, "Pony", VehicleType.CAR, 2),
    MULE(SAMPConstants.VEHICLE_MULE, "Mule", VehicleType.CAR, 2),
    CHEETAH(SAMPConstants.VEHICLE_CHEETAH, "Cheetah", VehicleType.CAR, 2),
    AMBULANCE(SAMPConstants.VEHICLE_AMBULANCE, "Ambulance", VehicleType.CAR, 4),
    LEVIATHAN(SAMPConstants.VEHICLE_LEVIATHAN, "Leviathan", VehicleType.HELICOPTER, 2),
    MOONBEAM(SAMPConstants.VEHICLE_MOONBEAM, "Moonbeam", VehicleType.CAR, 4),
    ESPERANTO(SAMPConstants.VEHICLE_ESPERANTO, "Esperanto", VehicleType.CAR, 2),
    TAXI(SAMPConstants.VEHICLE_TAXI, "Taxi", VehicleType.CAR, 4),
    WASHINGTON(SAMPConstants.VEHICLE_WASHINGTON, "Washington", VehicleType.CAR, 4),
    BOBCAT(SAMPConstants.VEHICLE_BOBCAT, "Bobcat", VehicleType.CAR, 2),
    MRWHOOPEE(SAMPConstants.VEHICLE_MRWHOOPEE, "Mr Whoopee", VehicleType.CAR, 2),
    BFINJECTION(SAMPConstants.VEHICLE_BFINJECTION, "BF Injection", VehicleType.CAR, 2),
    HUNTER(SAMPConstants.VEHICLE_HUNTER, "Hunter", VehicleType.HELICOPTER, 1),
    PREMIER(SAMPConstants.VEHICLE_PREMIER, "Premier", VehicleType.CAR, 4),
    ENFORCER(SAMPConstants.VEHICLE_ENFORCER, "Enforcer", VehicleType.CAR, 4),
    SECURICAR(SAMPConstants.VEHICLE_SECURICAR, "Securicar", VehicleType.CAR, 4),
    BANSHEE(SAMPConstants.VEHICLE_BANSHEE, "Banshee", VehicleType.CAR, 2),
    PREDATOR(SAMPConstants.VEHICLE_PREDATOR, "Predator", VehicleType.BOAT, 0),
    BUS(SAMPConstants.VEHICLE_BUS, "Bus", VehicleType.CAR, 8),
    RHINO(SAMPConstants.VEHICLE_RHINO, "Rhino", VehicleType.TANK, 1),
    BARRACKS(SAMPConstants.VEHICLE_BARRACKS, "Barracks", VehicleType.CAR, 2),
    HOTKNIFE(SAMPConstants.VEHICLE_HOTKNIFE, "Hotknife", VehicleType.CAR, 2),
    ARTICLETRAILER1(SAMPConstants.VEHICLE_ARTICLETRAILER1, "Trailer", VehicleType.TRAILER, 0),
    PREVION(SAMPConstants.VEHICLE_PREVION, "Previon", VehicleType.CAR, 2),
    COACH(SAMPConstants.VEHICLE_COACH, "Coach", VehicleType.CAR, 8),
    CABBIE(SAMPConstants.VEHICLE_CABBIE, "Cabbie", VehicleType.CAR, 4),
    STALLION(SAMPConstants.VEHICLE_STALLION, "Stallion", VehicleType.CAR, 2),
    RUMPO(SAMPConstants.VEHICLE_RUMPO, "Rumpo", VehicleType.CAR, 4),
    RCBANDIT(SAMPConstants.VEHICLE_RCBANDIT, "RC Bandit", VehicleType.REMOTE_CONTROL, 1),
    ROMERO(SAMPConstants.VEHICLE_ROMERO, "Romero", VehicleType.CAR, 2),
    PACKER(SAMPConstants.VEHICLE_PACKER, "Packer", VehicleType.CAR, 2),
    MONSTER(SAMPConstants.VEHICLE_MONSTER, "Monster", VehicleType.CAR, 2),
    ADMIRAL(SAMPConstants.VEHICLE_ADMIRAL, "Admiral", VehicleType.CAR, 4),
    SQUALO(SAMPConstants.VEHICLE_SQUALO, "Squalo", VehicleType.BOAT, 0),
    SEASPARROW(SAMPConstants.VEHICLE_SEASPARROW, "Seasparrow", VehicleType.HELICOPTER, 2),
    PIZZABOY(SAMPConstants.VEHICLE_PIZZABOY, "Pizzaboy", VehicleType.MOTORBIKE, 1),
    TRAM(SAMPConstants.VEHICLE_TRAM, "Tram", VehicleType.TRAIN, 4),
    ARTICLETRAILER2(SAMPConstants.VEHICLE_ARTICLETRAILER2, "Trailer", VehicleType.TRAILER, 0),
    TURISMO(SAMPConstants.VEHICLE_TURISMO, "Turismo", VehicleType.CAR, 2),
    SPEEDER(SAMPConstants.VEHICLE_SPEEDER, "Speeder", VehicleType.BOAT, 0),
    REEFER(SAMPConstants.VEHICLE_REEFER, "Reefer", VehicleType.BOAT, 0),
    TROPIC(SAMPConstants.VEHICLE_TROPIC, "Tropic", VehicleType.BOAT, 0),
    FLATBED(SAMPConstants.VEHICLE_FLATBED, "Flatbed", VehicleType.CAR, 2),
    YANKEE(SAMPConstants.VEHICLE_YANKEE, "Yankee", VehicleType.CAR, 2),
    CADDY(SAMPConstants.VEHICLE_CADDY, "Caddy", VehicleType.CAR, 2),
    SOLAIR(SAMPConstants.VEHICLE_SOLAIR, "Solair", VehicleType.CAR, 4),
    BERKLEYSRCVAN(SAMPConstants.VEHICLE_BERKLEYSRCVAN, "Berkleys RC Van", VehicleType.CAR, 4),
    SKIMMER(SAMPConstants.VEHICLE_SKIMMER, "Skimmer", VehicleType.AIRCRAFT, 2),
    PCJ600(SAMPConstants.VEHICLE_PCJ600, "PCJ-600", VehicleType.MOTORBIKE, 2),
    FAGGIO(SAMPConstants.VEHICLE_FAGGIO, "Faggio", VehicleType.MOTORBIKE, 2),
    FREEWAY(SAMPConstants.VEHICLE_FREEWAY, "Freeway", VehicleType.MOTORBIKE, 0),
    RCBARON(SAMPConstants.VEHICLE_RCBARON, "RC Baron", VehicleType.REMOTE_CONTROL, 1),
    RCRAIDER(SAMPConstants.VEHICLE_RCRAIDER, "RC Raider", VehicleType.REMOTE_CONTROL, 1),
    GLENDALE(SAMPConstants.VEHICLE_GLENDALE, "Glendale", VehicleType.CAR, 4),
    OCEANIC(SAMPConstants.VEHICLE_OCEANIC, "Oceanic", VehicleType.CAR, 4),
    SANCHEZ(SAMPConstants.VEHICLE_SANCHEZ, "Sanchez", VehicleType.MOTORBIKE, 2),
    SPARROW(SAMPConstants.VEHICLE_SPARROW, "Sparrow", VehicleType.HELICOPTER, 2),
    PATRIOT(SAMPConstants.VEHICLE_PATRIOT, "Patriot", VehicleType.CAR, 4),
    QUAD(SAMPConstants.VEHICLE_QUAD, "Quad", VehicleType.MOTORBIKE, 2),
    COASTGUARD(SAMPConstants.VEHICLE_COASTGUARD, "Coastguard", VehicleType.BOAT, 0),
    DINGHY(SAMPConstants.VEHICLE_DINGHY, "Dinghy", VehicleType.BOAT, 0),
    HERMES(SAMPConstants.VEHICLE_HERMES, "Hermes", VehicleType.CAR, 2),
    SABRE(SAMPConstants.VEHICLE_SABRE, "Sabre", VehicleType.CAR, 2),
    RUSTLER(SAMPConstants.VEHICLE_RUSTLER, "Rustler", VehicleType.AIRCRAFT, 1),
    ZR350(SAMPConstants.VEHICLE_ZR350, "ZR3 50", VehicleType.CAR, 2),
    WALTON(SAMPConstants.VEHICLE_WALTON, "Walton", VehicleType.CAR, 2),
    REGINA(SAMPConstants.VEHICLE_REGINA, "Regina", VehicleType.CAR, 4),
    COMET(SAMPConstants.VEHICLE_COMET, "Comet", VehicleType.CAR, 2),
    BMX(SAMPConstants.VEHICLE_BMX, "BMX", VehicleType.BICYCLE, 1),
    BURRITO(SAMPConstants.VEHICLE_BURRITO, "Burrito", VehicleType.CAR, 4),
    CAMPER(SAMPConstants.VEHICLE_CAMPER, "Camper", VehicleType.CAR, 3),
    MARQUIS(SAMPConstants.VEHICLE_MARQUIS, "Marquis", VehicleType.BOAT, 0),
    BAGGAGE(SAMPConstants.VEHICLE_BAGGAGE, "Baggage", VehicleType.CAR, 1),
    DOZER(SAMPConstants.VEHICLE_DOZER, "Dozer", VehicleType.CAR, 1),
    MAVERICK(SAMPConstants.VEHICLE_MAVERICK, "Maverick", VehicleType.HELICOPTER, 4),
    SANNEWSMAVERICK(SAMPConstants.VEHICLE_SANNEWSMAVERICK, "News Chopper", VehicleType.HELICOPTER, 2),
    RANCHER(SAMPConstants.VEHICLE_RANCHER, "Rancher", VehicleType.CAR, 2),
    FBIRANCHER(SAMPConstants.VEHICLE_FBIRANCHER, "FBI Rancher", VehicleType.CAR, 4),
    VIRGO(SAMPConstants.VEHICLE_VIRGO, "Virgo", VehicleType.CAR, 2),
    GREENWOOD(SAMPConstants.VEHICLE_GREENWOOD, "Greenwood", VehicleType.CAR, 2),
    JETMAX(SAMPConstants.VEHICLE_JETMAX, "Jetmax", VehicleType.BOAT, 0),
    HOTRINGRACER(SAMPConstants.VEHICLE_HOTRINGRACER, "Hotring", VehicleType.CAR, 2),
    SANDKING(SAMPConstants.VEHICLE_SANDKING, "Sandking", VehicleType.CAR, 2),
    BLISTACOMPACT(SAMPConstants.VEHICLE_BLISTACOMPACT, "Blista Compact", VehicleType.CAR, 2),
    POLICEMAVERICK(SAMPConstants.VEHICLE_POLICEMAVERICK, "Police Maverick", VehicleType.HELICOPTER, 4),
    BOXVILLE(SAMPConstants.VEHICLE_BOXVILLE, "Boxville", VehicleType.CAR, 4),
    BENSON(SAMPConstants.VEHICLE_BENSON, "Benson", VehicleType.CAR, 2),
    MESA(SAMPConstants.VEHICLE_MESA, "Mesa", VehicleType.CAR, 2),
    RCGOBLIN(SAMPConstants.VEHICLE_RCGOBLIN, "RC Goblin", VehicleType.REMOTE_CONTROL, 1),
    HOTRINGRACERA(SAMPConstants.VEHICLE_HOTRINGRACERA, "Hotring Racer", VehicleType.CAR, 2),
    HOTRINGRACERB(SAMPConstants.VEHICLE_HOTRINGRACERB, "Hotring Racer", VehicleType.CAR, 2),
    BLOODRINGBANGER(SAMPConstants.VEHICLE_BLOODRINGBANGER, "Bloodring Banger", VehicleType.CAR, 2),
    RANCHERLURE(SAMPConstants.VEHICLE_RANCHERLURE, "Rancher", VehicleType.CAR, 2),
    SUPERGT(SAMPConstants.VEHICLE_SUPERGT, "Super GT", VehicleType.CAR, 2),
    ELEGANT(SAMPConstants.VEHICLE_ELEGANT, "Elegant", VehicleType.CAR, 4),
    JOURNEY(SAMPConstants.VEHICLE_JOURNEY, "Journey", VehicleType.CAR, 2),
    BIKE(SAMPConstants.VEHICLE_BIKE, "Bike", VehicleType.BICYCLE, 1),
    MOUNTAINBIKE(SAMPConstants.VEHICLE_MOUNTAINBIKE, "Mountain Bike", VehicleType.BICYCLE, 1),
    BEAGLE(SAMPConstants.VEHICLE_BEAGLE, "Beagle", VehicleType.AIRCRAFT, 2),
    CROPDUST(SAMPConstants.VEHICLE_CROPDUST, "Cropdust", VehicleType.AIRCRAFT, 1),
    STUNTPLANE(SAMPConstants.VEHICLE_STUNTPLANE, "Stunt", VehicleType.AIRCRAFT, 1),
    TANKER(SAMPConstants.VEHICLE_TANKER, "Tanker", VehicleType.CAR, 2),
    ROADTRAIN(SAMPConstants.VEHICLE_ROADTRAIN, "RoadTrain", VehicleType.CAR, 2),
    NEBULA(SAMPConstants.VEHICLE_NEBULA, "Nebula", VehicleType.CAR, 4),
    MAJESTIC(SAMPConstants.VEHICLE_MAJESTIC, "Majestic", VehicleType.CAR, 2),
    BUCCANEER(SAMPConstants.VEHICLE_BUCCANEER, "Buccaneer", VehicleType.CAR, 2),
    SHAMAL(SAMPConstants.VEHICLE_SHAMAL, "Shamal", VehicleType.AIRCRAFT, 1),
    HYDRA(SAMPConstants.VEHICLE_HYDRA, "Hydra", VehicleType.AIRCRAFT, 1),
    FCR900(SAMPConstants.VEHICLE_FCR900, "FCR-900", VehicleType.MOTORBIKE, 2),
    NRG500(SAMPConstants.VEHICLE_NRG500, "NRG-500", VehicleType.MOTORBIKE, 2),
    HPV1000(SAMPConstants.VEHICLE_HPV1000, "HPV1000", VehicleType.MOTORBIKE, 2),
    CEMENTTRUCK(SAMPConstants.VEHICLE_CEMENTTRUCK, "Cement Truck", VehicleType.CAR, 2),
    TOWTRUCK(SAMPConstants.VEHICLE_TOWTRUCK, "Tow Truck", VehicleType.CAR, 2),
    FORTUNE(SAMPConstants.VEHICLE_FORTUNE, "Fortune", VehicleType.CAR, 2),
    CADRONA(SAMPConstants.VEHICLE_CADRONA, "Cadrona", VehicleType.CAR, 2),
    FBITRUCK(SAMPConstants.VEHICLE_FBITRUCK, "FBI Truck", VehicleType.CAR, 2),
    WILLARD(SAMPConstants.VEHICLE_WILLARD, "Willard", VehicleType.CAR, 4),
    FORKLIFT(SAMPConstants.VEHICLE_FORKLIFT, "Forklift", VehicleType.CAR, 1),
    TRACTOR(SAMPConstants.VEHICLE_TRACTOR, "Tractor", VehicleType.CAR, 1),
    COMBINE(SAMPConstants.VEHICLE_COMBINE, "Combine", VehicleType.CAR, 1),
    FELTZER(SAMPConstants.VEHICLE_FELTZER, "Feltzer", VehicleType.CAR, 2),
    REMINGTON(SAMPConstants.VEHICLE_REMINGTON, "Remington", VehicleType.CAR, 2),
    SLAMVAN(SAMPConstants.VEHICLE_SLAMVAN, "Slamvan", VehicleType.CAR, 2),
    BLADE(SAMPConstants.VEHICLE_BLADE, "Blade", VehicleType.CAR, 2),
    FREIGHT(SAMPConstants.VEHICLE_FREIGHT, "Freight", VehicleType.TRAIN, 2),
    BROWNSTREAK(SAMPConstants.VEHICLE_BROWNSTREAK, "Streak", VehicleType.TRAIN, 2),
    VORTEX(SAMPConstants.VEHICLE_VORTEX, "Vortex", VehicleType.BOAT, 0),
    VINCENT(SAMPConstants.VEHICLE_VINCENT, "Vincent", VehicleType.CAR, 4),
    BULLET(SAMPConstants.VEHICLE_BULLET, "Bullet", VehicleType.CAR, 2),
    CLOVER(SAMPConstants.VEHICLE_CLOVER, "Clover", VehicleType.CAR, 2),
    SADLER(SAMPConstants.VEHICLE_SADLER, "Sadler", VehicleType.CAR, 2),
    FIRETRUCKLA(SAMPConstants.VEHICLE_FIRETRUCKLA, "Firetruck", VehicleType.CAR, 2),
    HUSTLER(SAMPConstants.VEHICLE_HUSTLER, "Hustler", VehicleType.CAR, 2),
    INTRUDER(SAMPConstants.VEHICLE_INTRUDER, "Intruder", VehicleType.CAR, 4),
    PRIMO(SAMPConstants.VEHICLE_PRIMO, "Primo", VehicleType.CAR, 4),
    CARGOBOB(SAMPConstants.VEHICLE_CARGOBOB, "Cargobob", VehicleType.HELICOPTER, 2),
    TAMPA(SAMPConstants.VEHICLE_TAMPA, "Tampa", VehicleType.CAR, 2),
    SUNRISE(SAMPConstants.VEHICLE_SUNRISE, "Sunrise", VehicleType.CAR, 4),
    MERIT(SAMPConstants.VEHICLE_MERIT, "Merit", VehicleType.CAR, 4),
    UTILITYVAN(SAMPConstants.VEHICLE_UTILITYVAN, "Utility", VehicleType.CAR, 2),
    NEVADA(SAMPConstants.VEHICLE_NEVADA, "Nevada", VehicleType.AIRCRAFT, 1),
    YOSEMITE(SAMPConstants.VEHICLE_YOSEMITE, "Yosemite", VehicleType.CAR, 2),
    WINDSOR(SAMPConstants.VEHICLE_WINDSOR, "Windsor", VehicleType.CAR, 2),
    MONSTERA(SAMPConstants.VEHICLE_MONSTERA, "Monster", VehicleType.CAR, 2),
    MONSTERB(SAMPConstants.VEHICLE_MONSTERB, "Monster", VehicleType.CAR, 2),
    URANUS(SAMPConstants.VEHICLE_URANUS, "Uranus", VehicleType.CAR, 2),
    JESTER(SAMPConstants.VEHICLE_JESTER, "Jester", VehicleType.CAR, 2),
    SULTAN(SAMPConstants.VEHICLE_SULTAN, "Sultan", VehicleType.CAR, 4),
    STRATUM(SAMPConstants.VEHICLE_STRATUM, "Stratum", VehicleType.CAR, 4),
    ELEGY(SAMPConstants.VEHICLE_ELEGY, "Elegy", VehicleType.CAR, 2),
    RAINDANCE(SAMPConstants.VEHICLE_RAINDANCE, "Raindance", VehicleType.HELICOPTER, 2),
    RCTIGER(SAMPConstants.VEHICLE_RCTIGER, "RC Tiger", VehicleType.REMOTE_CONTROL, 1),
    FLASH(SAMPConstants.VEHICLE_FLASH, "Flash", VehicleType.CAR, 2),
    TAHOMA(SAMPConstants.VEHICLE_TAHOMA, "Tahoma", VehicleType.CAR, 4),
    SAVANNA(SAMPConstants.VEHICLE_SAVANNA, "Savanna", VehicleType.CAR, 4),
    BANDITO(SAMPConstants.VEHICLE_BANDITO, "Bandito", VehicleType.CAR, 1),
    FREIGHTFLATTRAILER(SAMPConstants.VEHICLE_FREIGHTFLATTRAILER, "Freight", VehicleType.TRAIN, 0),
    STREAKTRAILER(SAMPConstants.VEHICLE_STREAKTRAILER, "Trailer", VehicleType.TRAIN, 0),
    KART(SAMPConstants.VEHICLE_KART, "Kart", VehicleType.CAR, 1),
    MOWER(SAMPConstants.VEHICLE_MOWER, "Mower", VehicleType.CAR, 1),
    DUNERIDE(SAMPConstants.VEHICLE_DUNERIDE, "Duneride", VehicleType.CAR, 2),
    SWEEPER(SAMPConstants.VEHICLE_SWEEPER, "Sweeper", VehicleType.CAR, 1),
    BROADWAY(SAMPConstants.VEHICLE_BROADWAY, "Broadway", VehicleType.CAR, 2),
    TORNADO(SAMPConstants.VEHICLE_TORNADO, "Tornado", VehicleType.CAR, 2),
    AT400(SAMPConstants.VEHICLE_AT400, "AT-400", VehicleType.AIRCRAFT, 1),
    DFT30(SAMPConstants.VEHICLE_DFT30, "DFT-30", VehicleType.CAR, 2),
    HUNTLEY(SAMPConstants.VEHICLE_HUNTLEY, "Huntley", VehicleType.CAR, 4),
    STAFFORD(SAMPConstants.VEHICLE_STAFFORD, "Stafford", VehicleType.CAR, 4),
    BF400(SAMPConstants.VEHICLE_BF400, "BF-400", VehicleType.MOTORBIKE, 2),
    NEWSVAN(SAMPConstants.VEHICLE_NEWSVAN, "Newsvan", VehicleType.CAR, 2),
    TUG(SAMPConstants.VEHICLE_TUG, "Tug", VehicleType.CAR, 1),
    PETROLTRAILER(SAMPConstants.VEHICLE_PETROLTRAILER, "Trailer", VehicleType.TRAILER, 0),
    EMPEROR(SAMPConstants.VEHICLE_EMPEROR, "Emperor", VehicleType.CAR, 4),
    WAYFARER(SAMPConstants.VEHICLE_WAYFARER, "Wayfarer", VehicleType.MOTORBIKE, 2),
    EUROS(SAMPConstants.VEHICLE_EUROS, "Euros", VehicleType.CAR, 2),
    HOTDOG(SAMPConstants.VEHICLE_HOTDOG, "Hotdog", VehicleType.CAR, 2),
    CLUB(SAMPConstants.VEHICLE_CLUB, "Club", VehicleType.CAR, 2),
    FREIGHTBOXTRAILER(SAMPConstants.VEHICLE_FREIGHTBOXTRAILER, "Trailer", VehicleType.TRAILER, 0),
    ARTICLETRAILER3(SAMPConstants.VEHICLE_ARTICLETRAILER3, "Trailer", VehicleType.TRAILER, 0),
    ANDROMADA(SAMPConstants.VEHICLE_ANDROMADA, "Andromada", VehicleType.AIRCRAFT, 2),
    DODO(SAMPConstants.VEHICLE_DODO, "Dodo", VehicleType.AIRCRAFT, 2),
    RCCAM(SAMPConstants.VEHICLE_RCCAM, "RC Cam", VehicleType.REMOTE_CONTROL, 1),
    LAUNCH(SAMPConstants.VEHICLE_LAUNCH, "Launch", VehicleType.BOAT, 0),
    POLICECARLSPD(SAMPConstants.VEHICLE_POLICECARLSPD, "Police Car LSPD", VehicleType.CAR, 4),
    POLICECARSFPD(SAMPConstants.VEHICLE_POLICECARSFPD, "Police Car SFPD", VehicleType.CAR, 4),
    POLICECARLVPD(SAMPConstants.VEHICLE_POLICECARLVPD, "Police Car LVPD", VehicleType.CAR, 4),
    POLICERANGER(SAMPConstants.VEHICLE_POLICERANGER, "Police Ranger", VehicleType.CAR, 2),
    PICADOR(SAMPConstants.VEHICLE_PICADOR, "Picador", VehicleType.CAR, 2),
    SWAT(SAMPConstants.VEHICLE_SWAT, "SWAT Van", VehicleType.CAR, 2),
    ALPHA(SAMPConstants.VEHICLE_ALPHA, "Alpha", VehicleType.CAR, 2),
    PHOENIX(SAMPConstants.VEHICLE_PHOENIX, "Phoenix", VehicleType.CAR, 2),
    GLENDALESHIT(SAMPConstants.VEHICLE_GLENDALESHIT, "Glendale", VehicleType.CAR, 4),
    SADLERSHIT(SAMPConstants.VEHICLE_SADLERSHIT, "Sadler", VehicleType.CAR, 2),
    BAGGAGETRAILERA(SAMPConstants.VEHICLE_BAGGAGETRAILERA, "Luggage Trailer", VehicleType.TRAILER, 0),
    BAGGAGETRAILERB(SAMPConstants.VEHICLE_BAGGAGETRAILERB, "Luggage Trailer", VehicleType.TRAILER, 0),
    TUGSTAIRSTRAILER(SAMPConstants.VEHICLE_TUGSTAIRSTRAILER, "Stair Trailer", VehicleType.TRAILER, 0),
    BOXBURG(SAMPConstants.VEHICLE_BOXBURG, "Boxville", VehicleType.CAR, 4),
    FARMTRAILER(SAMPConstants.VEHICLE_FARMTRAILER, "Farm Plow", VehicleType.TRAILER, 0),
    UTILITYTRAILER(SAMPConstants.VEHICLE_UTILITYTRAILER, "Utility Trailer", VehicleType.TRAILER, 0);

    companion object : ConstantValueRegistry<Int, VehicleModel>(*VehicleModel.values())

}
