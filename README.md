# minecraft-kebab-mod
Advanced Kebab Shop Mod for Minecraft 1.20.1 Fabric - Gelişmiş Dönerci Modu

## 🍖 Features / Özellikler

### Blocks / Bloklar
- **Döner Machine (Döner Makinesi)** - Cooks raw döner meat with rotating animation / Çiğ döner etini pişirir (dönen animasyonlu)
- **Preparation Table (Hazırlama Masası)** - Assemble döner wraps with ingredients / Malzemelerle döner dürüm hazırla
- **Display Counter (Vitrin Tezgahı)** - Display and store items / Eşyaları sergile ve depola

### Items & Food / Malzemeler & Yemekler

#### Raw Meats / Çiğ Etler
- Raw Chicken Döner (Çiğ Tavuk Döner)
- Raw Lamb Döner (Çiğ Kuzu Döner)
- Raw Beef Döner (Çiğ Dana Döner)

#### Cooked Meats / Pişmiş Etler
- Cooked Chicken Döner (Pişmiş Tavuk Döner)
- Cooked Lamb Döner (Pişmiş Kuzu Döner)
- Cooked Beef Döner (Pişmiş Dana Döner)

#### Sliced Meats / Dilimlenmiş Etler
- Sliced Chicken Döner (Dilimlenmiş Tavuk Döner)
- Sliced Lamb Döner (Dilimlenmiş Kuzu Döner)
- Sliced Beef Döner (Dilimlenmiş Dana Döner)

#### Vegetables & Bread / Sebzeler & Ekmek
- Pita Bread (Pide Ekmeği)
- Lettuce (Marul)
- Tomato (Domates)
- Onion (Soğan)
- Pickle (Turşu)

#### Sauces / Soslar
- Garlic Sauce (Sarımsak Sosu)
- Hot Sauce (Acı Sos)
- Yogurt Sauce (Yoğurt Sosu)

#### Finished Products / Bitmiş Ürünler
- Chicken Döner Wrap (Tavuk Döner Dürüm) - 12 hunger, 0.8 saturation
- Lamb Döner Wrap (Kuzu Döner Dürüm) - 14 hunger, 0.9 saturation
- Beef Döner Wrap (Dana Döner Dürüm) - 13 hunger, 0.85 saturation

#### Tools & Currency / Araçlar & Para
- Döner Knife (Döner Bıçağı) - 250 durability, used to slice cooked meat
- Turkish Lira (Türk Lirası) - Currency for trading with customers

### NPCs / NPC'ler
- **Customer Entity (Müşteri)** - Spawns with random orders, pays with Turkish Lira

## 🎮 How to Play / Nasıl Oynanır

### Making Döner / Döner Yapımı

1. **Craft a Döner Machine**
   - Recipe: Iron Ingots + Furnace
   - Tarif: Demir Külçeler + Fırın

2. **Prepare Raw Döner**
   - Craft raw döner from 3x raw meat (chicken/mutton/beef)
   - 3 adet çiğ etten (tavuk/kuzu/dana) çiğ döner yap

3. **Cook the Döner**
   - Place raw döner in the Döner Machine
   - Machine will cook it automatically (10 seconds)
   - Çiğ döneri Döner Makinesine koy
   - Makine otomatik pişirir (10 saniye)

4. **Slice the Meat**
   - Craft a Döner Knife
   - Right-click the Döner Machine with the knife
   - Each cooked döner gives 3 sliced pieces
   - Döner Bıçağı yap
   - Bıçakla Döner Makinesine sağ tıkla
   - Her pişmiş döner 3 dilim verir

5. **Assemble the Wrap**
   - Craft a Preparation Table
   - Place: Sliced meat, pita bread, lettuce, tomato
   - Optional: Add onion, pickle, and sauce for extra flavor
   - Hazırlama Masası yap
   - Koy: Dilimlenmiş et, pide ekmeği, marul, domates
   - İsteğe bağlı: Soğan, turşu ve sos ekle

### Trading with Customers / Müşterilerle Ticaret

1. Customers will spawn near your shop
2. Right-click to see their order
3. Give them the requested döner wrap
4. Receive Turkish Lira as payment
5. Customers leave after 5 minutes if not served

1. Müşteriler dükkanın yakınında belirir
2. Siparişlerini görmek için sağ tıkla
3. İstedikleri dürümü ver
4. Türk Lirası ödemesini al
5. Servis yapılmazsa 5 dakika sonra giderler

## 📦 Crafting Recipes / Tarifler

### Blocks
- **Döner Machine**: 8 Iron Ingots + 1 Furnace
- **Preparation Table**: 3 Planks + 3 Slabs
- **Display Counter**: 3 Glass Panes + 3 Planks

### Items
- **Pita Bread**: 3 Wheat → 3 Pita Bread
- **Raw Döner**: 3x Same Meat Type → 1 Raw Döner
- **Döner Knife**: 1 Iron Ingot + 2 Sticks

## 🔧 Installation / Kurulum

1. Install Fabric Loader for Minecraft 1.20.1
2. Install Fabric API
3. Download this mod
4. Place the .jar file in your mods folder
5. Launch Minecraft with Fabric profile

1. Minecraft 1.20.1 için Fabric Loader kur
2. Fabric API kur
3. Bu modu indir
4. .jar dosyasını mods klasörüne koy
5. Minecraft'ı Fabric profiliyle başlat

## 🛠️ Building from Source / Kaynak Koddan Derleme

**Note:** Build requires network connectivity to Fabric Maven repository.

```bash
./gradlew build
```

The built jar will be in `build/libs/`

## 📝 Technical Details / Teknik Detaylar

- **Minecraft Version**: 1.20.1
- **Mod Loader**: Fabric
- **Fabric API**: Required
- **Language Support**: English, Turkish (Türkçe)

### Code Structure
- `item/` - All mod items and food components
- `block/` - Döner machine, preparation table, display counter
- `blockentity/` - Block entity logic for machines
- `entity/` - Customer NPC entity
- `screen/` - GUI handlers and screens
- `assets/` - Textures, models, translations
- `data/` - Recipes and loot tables

## 🤝 Contributing / Katkıda Bulunma

Contributions are welcome! Feel free to open issues or pull requests.
Katkılar memnuniyetle karşılanır! Sorun bildirin veya pull request açın.

## 📜 License

MIT License - See LICENSE file for details

---

Made with ❤️ for Minecraft Turkey community
Minecraft Türkiye topluluğu için ❤️ ile yapıldı
