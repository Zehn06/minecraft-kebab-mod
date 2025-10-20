# Developer Quick Start Guide

## Project Structure

```
minecraft-kebab-mod/
├── src/main/
│   ├── java/com/zehn06/kebabmod/
│   │   ├── KebabMod.java              # Main mod class
│   │   ├── KebabModClient.java        # Client initialization
│   │   ├── block/                     # Block definitions
│   │   │   ├── ModBlocks.java         # Block registration
│   │   │   ├── DonerMachineBlock.java
│   │   │   ├── PreparationTableBlock.java
│   │   │   └── DisplayCounterBlock.java
│   │   ├── blockentity/               # Block entity logic
│   │   │   ├── ModBlockEntities.java
│   │   │   ├── DonerMachineBlockEntity.java
│   │   │   ├── PreparationTableBlockEntity.java
│   │   │   └── ImplementedInventory.java
│   │   ├── entity/                    # Entity definitions
│   │   │   ├── ModEntities.java
│   │   │   └── CustomerEntity.java
│   │   ├── item/                      # Item definitions
│   │   │   ├── ModItems.java
│   │   │   └── DonerKnifeItem.java
│   │   └── screen/                    # GUI system
│   │       ├── ModScreenHandlers.java
│   │       ├── DonerMachineScreenHandler.java
│   │       ├── PreparationTableScreenHandler.java
│   │       ├── DonerMachineScreen.java
│   │       └── PreparationTableScreen.java
│   └── resources/
│       ├── fabric.mod.json            # Mod metadata
│       ├── kebab-mod.mixins.json      # Mixin configuration
│       ├── assets/kebab-mod/
│       │   ├── blockstates/           # Block state definitions
│       │   ├── models/                # 3D models
│       │   │   ├── block/
│       │   │   └── item/
│       │   ├── textures/              # All textures
│       │   │   ├── block/
│       │   │   ├── item/
│       │   │   └── gui/
│       │   └── lang/                  # Translations
│       │       ├── en_us.json
│       │       └── tr_tr.json
│       └── data/kebab-mod/
│           └── recipes/               # Crafting recipes
├── gradle/                            # Gradle wrapper
├── build.gradle                       # Build configuration
├── gradle.properties                  # Version properties
└── settings.gradle                    # Project settings
```

## Building the Mod

### Prerequisites
- Java 17 or higher
- Gradle 8.5+ (included via wrapper)
- Internet connection (for first build)

### Build Commands

```bash
# Build the mod
./gradlew build

# Clean build artifacts
./gradlew clean

# Generate IntelliJ IDEA project
./gradlew idea

# Generate Eclipse project
./gradlew eclipse

# Run Minecraft client (for testing)
./gradlew runClient

# Run Minecraft server (for testing)
./gradlew runServer
```

### Output
Built mod JAR will be in: `build/libs/kebab-mod-1.0.0.jar`

## Development Setup

### IntelliJ IDEA
1. Open the project folder
2. Wait for Gradle sync
3. Run `./gradlew genSources` to generate Minecraft sources
4. Run configurations will be auto-generated

### Eclipse
1. Run `./gradlew eclipse`
2. Import as existing Eclipse project
3. Run `./gradlew genSources`

### VS Code
1. Install Java Extension Pack
2. Install Gradle for Java
3. Open project folder
4. Run `./gradlew genSources`

## Adding New Features

### Adding a New Item
1. Define item in `ModItems.java`:
```java
public static final Item MY_ITEM = registerItem("my_item", 
    new Item(new FabricItemSettings()));
```

2. Add to item group:
```java
content.add(MY_ITEM);
```

3. Create model: `assets/kebab-mod/models/item/my_item.json`
4. Create texture: `assets/kebab-mod/textures/item/my_item.png`
5. Add translation in `lang/en_us.json` and `lang/tr_tr.json`

### Adding a New Block
1. Define block in `ModBlocks.java`:
```java
public static final Block MY_BLOCK = registerBlock("my_block",
    new Block(FabricBlockSettings.create()...));
```

2. Create blockstate: `assets/kebab-mod/blockstates/my_block.json`
3. Create block model: `assets/kebab-mod/models/block/my_block.json`
4. Create item model: `assets/kebab-mod/models/item/my_block.json`
5. Create texture: `assets/kebab-mod/textures/block/my_block.png`
6. Add translations

### Adding a New Entity
1. Define entity in `ModEntities.java`
2. Create entity class extending appropriate base class
3. Implement behavior methods
4. Register attributes if needed
5. Add translations

### Adding a New Recipe
1. Create JSON file in `data/kebab-mod/recipes/`
2. Follow Minecraft recipe format:
   - `crafting_shaped` - Grid-based crafting
   - `crafting_shapeless` - Order-independent crafting
   - `smelting` - Furnace recipes
   - Custom types (requires recipe serializer)

## Code Style

### Java Conventions
- Use camelCase for methods and variables
- Use PascalCase for classes
- Use UPPER_SNAKE_CASE for constants
- Maximum line length: 120 characters
- Indent with tabs (IDE default)

### Naming Conventions
- Items: `item_name` (snake_case)
- Blocks: `block_name` (snake_case)
- Entities: `entity_name` (snake_case)
- Classes: `ClassName` (PascalCase)

### Documentation
- Add JavaDoc for public APIs
- Comment complex logic
- Use descriptive variable names
- Keep methods focused and small

## Testing

### Manual Testing
1. Run `./gradlew runClient`
2. Test in creative mode first
3. Verify all recipes work
4. Test block entity interactions
5. Test entity spawning and behavior
6. Check multiplayer compatibility

### What to Test
- [ ] All items appear in creative menu
- [ ] All blocks can be placed and broken
- [ ] Döner machine cooks meat correctly
- [ ] Döner knife slices meat
- [ ] Preparation table crafts wraps
- [ ] Customer NPCs spawn and function
- [ ] Translations display correctly
- [ ] GUIs open and work properly
- [ ] Recipes are discoverable
- [ ] No crashes or errors in log

## Debugging

### Common Issues

**"Class not found" errors**
- Run `./gradlew clean build`
- Regenerate sources: `./gradlew genSources`

**Textures missing**
- Check file paths match JSON references
- Ensure PNG files are valid
- Clear asset cache

**Blocks not rendering**
- Verify blockstate JSON
- Check model files
- Ensure textures exist

**Items not registering**
- Check registration order
- Verify mod ID matches
- Look for typos in identifiers

### Debug Logging
Add to your code:
```java
KebabMod.LOGGER.info("Debug message");
KebabMod.LOGGER.warn("Warning message");
KebabMod.LOGGER.error("Error message");
```

## Contributing

### Pull Request Process
1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Update documentation
6. Submit pull request with clear description

### Code Review Checklist
- [ ] Code follows style guidelines
- [ ] All new features are documented
- [ ] Translations added (EN + TR)
- [ ] No compilation warnings
- [ ] Textures are appropriate quality
- [ ] Performance is acceptable
- [ ] No conflicts with existing features

## Resources

### Fabric Documentation
- [Fabric Wiki](https://fabricmc.net/wiki/)
- [Fabric API Docs](https://maven.fabricmc.net/docs/fabric-api-0.92.2+1.20.1/)
- [Yarn Mappings](https://maven.fabricmc.net/docs/yarn-1.20.1+build.10/)

### Minecraft Development
- [Minecraft Wiki](https://minecraft.wiki/)
- [Fabric Discord](https://discord.gg/v6v4pMv)
- [Fabric Tutorials](https://fabricmc.net/wiki/tutorial:introduction)

### Tools
- [Blockbench](https://blockbench.net/) - 3D model editor
- [MCreator](https://mcreator.net/) - Visual mod maker
- [GIMP](https://gimp.org/) - Texture editor
- [Paint.NET](https://getpaint.net/) - Texture editor

## License

This project is licensed under the MIT License - see LICENSE file.

## Support

For questions or issues:
1. Check existing GitHub issues
2. Create a new issue with details
3. Join Fabric Discord for help
4. Read Fabric documentation

---

Happy modding! 🍖
