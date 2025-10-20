# minecraft-kebab-mod
Advanced Kebab Shop Mod for Minecraft 1.20.1 Fabric - Gelişmiş Dönerci Modu

## Features / Özellikler

### Blocks / Bloklar
- **Döner Machine** (dönen animasyonlu) - Rotating doner machine with animation
- **Preparation Table** - Hazırlama Masası
- **Display Counter** - Vitrin/Tezgah

### Items / Eşyalar
**Raw Meats / Çiğ Etler:**
- Raw Chicken Meat / Çiğ Tavuk Eti
- Raw Lamb Meat / Çiğ Kuzu Eti  
- Raw Beef Meat / Çiğ Dana Eti

**Cooked Doner / Pişmiş Döner:**
- Cooked Chicken Doner / Pişmiş Tavuk Döner
- Cooked Lamb Doner / Pişmiş Kuzu Döner
- Cooked Beef Doner / Pişmiş Dana Döner

**Ingredients / Malzemeler:**
- Pide Bread / Pide Ekmeği
- Lettuce / Marul
- Tomato / Domates
- Onion / Soğan
- Pickle / Turşu

**Sauces / Soslar:**
- Garlic Sauce / Sarımsaklı Sos
- Hot Sauce / Acı Sos
- Yogurt Sauce / Yoğurtlu Sos

**Doner Wraps / Dürümler:**
- Chicken Doner Wrap / Tavuk Döner Dürüm
- Lamb Doner Wrap / Kuzu Döner Dürüm
- Beef Doner Wrap / Dana Döner Dürüm

**Special Items / Özel Eşyalar:**
- Doner Knife / Döner Bıçağı
- Coin / Altın (Para)

### Entities / Varlıklar
- **Customer NPC** - Müşteri NPC'leri with order and payment system

### Mechanics / Mekanikler
- Döner Machine GUI with rotating animation
- Knife cutting system for meat
- Preparation Table crafting system
- Full economy system with coins
- Customer NPC ordering and payment

## Building / Derleme

**Note / Not:** This mod requires access to the Fabric Maven repository to build. If you're building in an environment without internet access to `maven.fabricmc.net`, you'll need to configure a local maven mirror or proxy.

To build the mod:
```bash
./gradlew build
```

The built jar will be in `build/libs/`

## Installation / Kurulum

1. Install Fabric Loader 0.15.11 or newer for Minecraft 1.20.1
2. Install Fabric API 0.92.2+1.20.1 or newer
3. Place the mod jar in your mods folder
4. Launch Minecraft

## Development / Geliştirme

- **Minecraft Version:** 1.20.1
- **Fabric Loader:** 0.15.11
- **Fabric API:** 0.92.2+1.20.1
- **Fabric Loom:** 0.12-SNAPSHOT
- **Java:** 17

## License

MIT License - See LICENSE file for details
