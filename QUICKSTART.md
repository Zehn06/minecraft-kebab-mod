# Quick Start Guide - Minecraft Kebab Mod

## For Players

### Installation

1. **Download Requirements:**
   - Minecraft 1.20.1
   - [Fabric Loader](https://fabricmc.net/use/) (0.15.0 or newer)
   - [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api) (0.92.0 or newer)

2. **Install the Mod:**
   - Download `kebab-mod-1.0.0.jar`
   - Place in `.minecraft/mods/` folder
   - Launch Minecraft with Fabric profile

3. **Verify Installation:**
   - In creative mode, check for "Kebab Mod" item tab
   - Should see döner machine, items, etc.

### How to Play

#### Step 1: Get Raw Materials
- Hunt animals or use creative mode
- Obtain: Raw Chicken/Lamb/Beef Meat

#### Step 2: Build Döner Machine
- Place Döner Machine block
- Right-click to open GUI
- You'll need a Döner Knife

#### Step 3: Cook Meat
```
1. Put raw meat in TOP slot
2. Put döner knife in LEFT slot  
3. Wait ~3 seconds
4. Cooked döner appears in RIGHT slot
```

#### Step 4: Gather Ingredients
You need:
- ✅ Cooked Döner (from machine)
- ✅ Pide Bread
- ✅ At least 1 vegetable (lettuce/tomato/onion/pickle)
- ✅ 1 sauce (garlic/hot/yogurt)

#### Step 5: Make Döner Wrap
- Place Preparation Table
- Right-click to open
- Add all ingredients
- Döner wrap appears in output!

#### Step 6: Serve Customers (Economy Mode)
- Find or spawn Customer NPC
- Right-click to get order
- Give them the correct döner wrap
- Receive 5-15 coins!

### Creative Mode Shortcuts

Get all items instantly:
```
/give @s kebabmod:doner_machine
/give @s kebabmod:doner_knife
/give @s kebabmod:raw_chicken_meat 64
/give @s kebabmod:pide_bread 64
/give @s kebabmod:lettuce 64
/give @s kebabmod:garlic_sauce 64
/give @s kebabmod:chicken_doner_wrap
```

Spawn customer:
```
/summon kebabmod:customer
```

---

## For Developers

### Build in 3 Commands

```bash
git clone https://github.com/Zehn06/minecraft-kebab-mod.git
cd minecraft-kebab-mod
./gradlew build
```

**Output:** `build/libs/kebab-mod-1.0.0.jar`

### Run Development Client

```bash
./gradlew runClient
```

### Common Tasks

**Clean build:**
```bash
./gradlew clean build
```

**Refresh dependencies:**
```bash
./gradlew build --refresh-dependencies
```

**Generate IDE files:**
```bash
./gradlew idea       # IntelliJ
./gradlew eclipse    # Eclipse
```

### File Locations

**Add custom textures:**
```
src/main/resources/assets/kebabmod/textures/
├── item/          ← 16x16 item textures
├── block/         ← 16x16 block textures
├── gui/           ← 176x166 GUI backgrounds
└── entity/        ← 64x64 entity skin
```

**Add translations:**
```
src/main/resources/assets/kebabmod/lang/
├── en_us.json     ← English
├── tr_tr.json     ← Turkish
└── [language].json ← Add more!
```

**Add recipes:**
```
src/main/resources/data/kebabmod/recipes/
└── your_recipe.json
```

### Quick Edits

**Change cooking time:**
- File: `DonerMachineBlockEntity.java`
- Line: `private int maxProgress = 72;`
- Change to any tick count (20 ticks = 1 second)

**Change customer prices:**
- File: `CustomerEntity.java`
- Line: `orderPrice = 5 + this.random.nextInt(10);`
- Adjust range

**Change food values:**
- File: `ModItems.java`
- Find: `.hunger(X).saturationModifier(Y)`
- Modify X (hunger) and Y (saturation)

---

## For Server Admins

### Server Installation

1. **Install Fabric Server:**
   ```bash
   java -jar fabric-server-launcher.jar
   ```

2. **Add Mods:**
   ```bash
   mkdir mods
   # Place fabric-api.jar in mods/
   # Place kebab-mod-1.0.0.jar in mods/
   ```

3. **Start Server:**
   ```bash
   java -Xmx2G -jar fabric-server-launcher.jar nogui
   ```

### Configuration

No config file needed - mod works out of the box!

To disable specific features, use datapacks or command blocks.

### Commands for Admins

**Give starter kit to player:**
```
/give @p kebabmod:doner_machine 1
/give @p kebabmod:preparation_table 1
/give @p kebabmod:doner_knife 1
/give @p kebabmod:raw_chicken_meat 16
```

**Spawn customers in village:**
```
/execute at @e[type=minecraft:villager] run summon kebabmod:customer ~ ~ ~
```

**Clear all customers:**
```
/kill @e[type=kebabmod:customer]
```

### Performance Tips

- Limit customer spawns (they use standard mob AI)
- Döner machines only tick when in use
- No lag concerns with normal usage

---

## Troubleshooting

### Mod Won't Load

**Check:**
- ✅ Correct Minecraft version (1.20.1)
- ✅ Fabric Loader installed
- ✅ Fabric API in mods folder
- ✅ Mod jar in mods folder

**Look for in logs:**
```
[kebabmod] Initializing Kebab Mod
```

If you see this, mod loaded successfully!

### Items Not Appearing

**Fix:**
- Restart Minecraft completely
- Check creative inventory "Kebab Mod" tab
- Try: `/give @s kebabmod:chicken_doner_wrap`

### Döner Machine Not Working

**Checklist:**
- [ ] Is there raw meat in top slot?
- [ ] Is there a knife in left slot?
- [ ] Does knife have durability left?
- [ ] Did you wait 3-4 seconds?

### Customers Not Spawning

Use command:
```
/summon kebabmod:customer ~ ~ ~
```

Natural spawning is not implemented (add with datapack if desired).

### Build Fails

**Error:** "Could not resolve fabric-loom"  
**Fix:** Check internet connection, maven.fabricmc.net must be accessible

**Error:** "Java version"  
**Fix:** Install Java 17 or newer

**Error:** "Could not find Minecraft"  
**Fix:** Run `./gradlew --refresh-dependencies`

---

## Need Help?

- **GitHub Issues:** [Report bugs](https://github.com/Zehn06/minecraft-kebab-mod/issues)
- **Documentation:** See README.md, IMPLEMENTATION.md, DEVELOPMENT.md
- **Logs:** Check `.minecraft/logs/latest.log`

---

## What's Next?

### For Players:
- Build a kebab shop
- Set up automated farm for ingredients
- Create customer service area
- Start a döner business on your server!

### For Developers:
- Add custom textures
- Create recipes for ingredients
- Add more NPC types
- Extend economy system
- Add achievements
- Create addon mods

---

**Enjoy your döner! 🌯**

Created with ❤️ by Zehn06  
Minecraft 1.20.1 | Fabric | MIT License
