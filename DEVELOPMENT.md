# Development Guide - Minecraft Kebab Mod

## Prerequisites

Before building this mod, ensure you have:

1. **Java Development Kit (JDK) 17 or newer**
   ```bash
   java -version
   # Should show Java 17 or higher
   ```

2. **Internet Connection**
   - Required to download dependencies from:
     - maven.fabricmc.net
     - repo.maven.apache.org
     - plugins.gradle.org

3. **Git** (for cloning the repository)
   ```bash
   git clone https://github.com/Zehn06/minecraft-kebab-mod.git
   cd minecraft-kebab-mod
   ```

## Building the Mod

### First Time Setup

1. **Make gradlew executable** (Linux/Mac):
   ```bash
   chmod +x gradlew
   ```

2. **Build the project**:
   ```bash
   ./gradlew build
   ```
   
   On Windows:
   ```cmd
   gradlew.bat build
   ```

The first build will download:
- Gradle 8.5
- Minecraft 1.20.1
- Fabric Loader
- Fabric API
- All dependencies

This may take 5-15 minutes depending on your internet speed.

### Subsequent Builds

```bash
./gradlew clean build
```

## Running in Development

### Launch Minecraft Client

```bash
./gradlew runClient
```

This will:
- Setup the development environment
- Launch Minecraft with the mod loaded
- Enable hot-reloading for some changes

### Launch Minecraft Server

```bash
./gradlew runServer
```

## Project Structure Explained

### Core Files

- **`src/main/java/`**: All Java source code
  - `KebabMod.java`: Main mod initializer (server-side)
  - `KebabModClient.java`: Client-side initializer
  
- **`src/main/resources/`**: All assets and data
  - `fabric.mod.json`: Mod metadata
  - `assets/kebabmod/`: Client-side resources (models, textures, translations)
  - `data/kebabmod/`: Server-side data (loot tables, recipes)

### Key Components

#### Blocks
- `ModBlocks.java`: Block registration
- `DonerMachineBlock.java`: Döner machine logic
- `PreparationTableBlock.java`: Preparation table logic

#### Block Entities
- `DonerMachineBlockEntity.java`: Handles döner machine state and cooking
- `PreparationTableBlockEntity.java`: Handles crafting wraps

#### Items
- `ModItems.java`: Item registration
- `DonerKnifeItem.java`: Custom knife with durability

#### Entities
- `CustomerEntity.java`: NPC customer AI and interaction
- `CustomerRenderer.java`: NPC rendering

#### Screens/GUIs
- `DonerMachineScreen.java`: Client-side GUI rendering
- `DonerMachineScreenHandler.java`: Server-side inventory handling
- Similar files for Preparation Table

## Adding Custom Textures

Replace the placeholder textures in:

```
src/main/resources/assets/kebabmod/textures/
├── item/          (16x16 PNG files)
├── block/         (16x16 PNG files)
├── gui/           (176x166 PNG files for machine GUIs)
└── entity/        (64x64 PNG file for customer NPC)
```

After replacing textures:
```bash
./gradlew build
```

## Testing Features

### In Creative Mode

1. **Get Items**:
   - Open creative inventory
   - Go to "Kebab Mod" tab
   - All items and blocks are there

2. **Test Döner Machine**:
   - Place Döner Machine
   - Right-click to open GUI
   - Put raw meat in top slot
   - Put Döner Knife in left slot
   - Cooked meat appears in right slot
   - Watch rotation animation

3. **Test Preparation Table**:
   - Place Preparation Table
   - Right-click to open GUI
   - Add: cooked meat, pide bread, vegetables, sauce
   - Döner wrap appears in output slot

4. **Test Customer NPC**:
   - Use spawn egg (if added) or summon command:
     ```
     /summon kebabmod:customer ~ ~ ~
     ```
   - Right-click to get order
   - Give correct döner wrap
   - Receive coins

### Commands for Testing

```
/give @s kebabmod:doner_knife
/give @s kebabmod:raw_chicken_meat 64
/give @s kebabmod:pide_bread 64
/give @s kebabmod:chicken_doner_wrap
/summon kebabmod:customer ~ ~ ~
```

## Common Issues

### Build Fails - "Could not resolve fabric-loom"

**Solution**: Ensure you have internet access. Fabric Loom is downloaded from maven.fabricmc.net.

### Build Fails - "Java version"

**Solution**: Install Java 17 or newer:
- Windows: Download from adoptium.net
- Linux: `sudo apt install openjdk-17-jdk`
- Mac: `brew install openjdk@17`

### Client Won't Launch

**Solution**: 
```bash
./gradlew clean
./gradlew runClient --refresh-dependencies
```

### Textures Not Loading

**Solution**:
- Check file names match exactly
- Ensure PNG format
- Run `./gradlew clean build` after adding textures

## Debugging

### Enable Debug Logs

Add to `gradle.properties`:
```properties
org.gradle.logging.level=debug
```

### Check Mod Loading

Look for in logs:
```
[kebabmod] Initializing Kebab Mod
[kebabmod] Registering Mod Items for kebabmod
[kebabmod] Registering ModBlocks for kebabmod
```

## IDE Setup

### IntelliJ IDEA

1. Import project:
   ```
   File > Open > Select build.gradle
   ```

2. Generate run configurations:
   ```bash
   ./gradlew idea
   ```

3. Run configurations will appear in Run menu

### Eclipse

1. Generate Eclipse files:
   ```bash
   ./gradlew eclipse
   ```

2. Import:
   ```
   File > Import > Existing Projects
   ```

### Visual Studio Code

1. Install extensions:
   - Extension Pack for Java
   - Gradle for Java

2. Open folder, VS Code will auto-detect

## Publishing

### Build Release JAR

```bash
./gradlew build
```

The mod jar will be at:
```
build/libs/kebab-mod-1.0.0.jar
```

### Upload to CurseForge

1. Create project on curseforge.com
2. Upload the jar from `build/libs/`
3. Select Minecraft 1.20.1 and Fabric

### Upload to Modrinth

1. Create project on modrinth.com
2. Upload the jar
3. Mark compatible with Fabric 1.20.1

## Extending the Mod

### Adding New Items

1. Add to `ModItems.java`:
```java
public static final Item NEW_ITEM = registerItem("new_item",
    new Item(new FabricItemSettings()));
```

2. Add translation to `lang/en_us.json`

3. Create model in `models/item/new_item.json`

4. Add texture to `textures/item/new_item.png`

### Adding New Blocks

1. Add to `ModBlocks.java`
2. Create block class if needed
3. Add blockstate JSON
4. Add model JSON
5. Add texture

### Adding Recipes

Create JSON in `data/kebabmod/recipes/`:
```json
{
  "type": "minecraft:crafting_shaped",
  "pattern": [
    "###",
    "# #",
    "###"
  ],
  "key": {
    "#": {
      "item": "minecraft:iron_ingot"
    }
  },
  "result": {
    "item": "kebabmod:doner_machine"
  }
}
```

## Support

For issues or questions:
- GitHub Issues: https://github.com/Zehn06/minecraft-kebab-mod/issues
- Check logs in: `.minecraft/logs/latest.log`

## Version Compatibility

- **Minecraft**: 1.20.1 only
- **Fabric Loader**: 0.15.0+
- **Fabric API**: 0.92.0+
- **Java**: 17+

To update for different Minecraft versions, modify:
- `gradle.properties`: Update version numbers
- Code: Check for API changes in new Minecraft versions
