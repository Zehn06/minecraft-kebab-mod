# Advanced Döner Mod - Feature Documentation

## Complete Feature List

### 🏗️ Blocks

#### 1. Döner Machine (Döner Makinesi)
**Purpose**: Cooks raw döner meat automatically
**Features**:
- Animated rotating mechanism (client-side)
- GUI with input/output slots
- Automatic cooking (200 ticks / 10 seconds per meat)
- Visual progress indicator
- Supports fuel slot for future expansion

**Usage**:
1. Right-click to open GUI
2. Place raw döner meat in input slot
3. Machine automatically cooks meat
4. Retrieve cooked meat from output slot
5. Use döner knife on the machine to slice cooked meat

**Crafting**: 8 Iron Ingots + 1 Furnace (center)

#### 2. Preparation Table (Hazırlama Masası)
**Purpose**: Assemble döner wraps from ingredients
**Features**:
- 10-slot inventory (7 ingredient + 2 storage + 1 output)
- Automatic crafting when ingredients are present
- Supports optional ingredients (onion, pickle, sauce)

**Required Ingredients**:
- Sliced döner meat (any type)
- Pita bread
- Lettuce
- Tomato

**Optional Ingredients**:
- Onion
- Pickle
- Any sauce

**Usage**:
1. Right-click to open GUI
2. Place required ingredients in slots
3. Wrap automatically crafts to output slot
4. Shift-click to quickly move items

**Crafting**: 3 Planks (top) + 3 Wooden Slabs (bottom)

#### 3. Display Counter (Vitrin Tezgahı)
**Purpose**: Decorative shop counter
**Features**:
- Reduced height (12 blocks) for realistic counter appearance
- Transparent rendering
- Perfect for shop displays

**Crafting**: 3 Glass Panes (top) + 3 Planks (bottom, any wood type)

### 🥩 Items - Meats

#### Raw Meats
All raw meats can be eaten but provide less nutrition than cooked versions.

1. **Raw Chicken Döner** 
   - Crafting: 3x Raw Chicken
   - Food Value: Same as raw chicken
   
2. **Raw Lamb Döner**
   - Crafting: 3x Mutton
   - Food Value: Same as mutton
   
3. **Raw Beef Döner**
   - Crafting: 3x Raw Beef
   - Food Value: Same as raw beef

#### Cooked Meats
Produced by the Döner Machine. Must be sliced before use in wraps.

1. **Cooked Chicken Döner**
   - Cooking: Raw Chicken Döner in Döner Machine
   - Food Value: Same as cooked chicken
   
2. **Cooked Lamb Döner**
   - Cooking: Raw Lamb Döner in Döner Machine
   - Food Value: Same as cooked mutton
   
3. **Cooked Beef Döner**
   - Cooking: Raw Beef Döner in Döner Machine
   - Food Value: Same as steak

#### Sliced Meats
Obtained by using Döner Knife on cooked meat in Döner Machine.

1. **Sliced Chicken Döner**
   - Obtained: 3 pieces per cooked chicken döner
   
2. **Sliced Lamb Döner**
   - Obtained: 3 pieces per cooked lamb döner
   
3. **Sliced Beef Döner**
   - Obtained: 3 pieces per cooked beef döner

### 🥙 Ingredients

#### Vegetables
**Lettuce (Marul)**
- Edible
- Required for döner wraps
- Grows in villages (future feature)

**Tomato (Domates)**
- Edible
- Required for döner wraps
- Can be farmed (future feature)

**Onion (Soğan)**
- Edible
- Optional for döner wraps
- Adds flavor

**Pickle (Turşu)**
- Edible
- Optional for döner wraps
- Traditional addition

#### Bread
**Pita Bread (Pide Ekmeği)**
- Crafting: 3x Wheat → 3 Pita Bread
- Required for all döner wraps
- Edible on its own

#### Sauces
All sauces stack to 16 and are optional in wraps.

**Garlic Sauce (Sarımsak Sosu)**
- Classic döner accompaniment
- White/cream colored

**Hot Sauce (Acı Sos)**
- For spicy döner lovers
- Red colored
- Future: May add fire resistance effect

**Yogurt Sauce (Yoğurt Sosu)**
- Traditional Turkish yogurt sauce
- Light colored
- Future: May add regeneration effect

### 🌯 Finished Products

#### Döner Wraps
All wraps are complete meals with high nutrition values.

**Chicken Döner Wrap (Tavuk Döner Dürüm)**
- Hunger: 12 (6 drumsticks)
- Saturation: 0.8
- Healthiest option

**Lamb Döner Wrap (Kuzu Döner Dürüm)**
- Hunger: 14 (7 drumsticks)
- Saturation: 0.9
- Most filling option
- Premium price

**Beef Döner Wrap (Dana Döner Dürüm)**
- Hunger: 13 (6.5 drumsticks)
- Saturation: 0.85
- Balanced option

### 🔪 Tools

#### Döner Knife (Döner Bıçağı)
**Durability**: 250 uses
**Functions**:
1. Slice cooked döner on Döner Machine (right-click)
2. Combat weapon (deals 2 damage per hit)
3. Loses 1 durability per slice
4. Loses 2 durability when used as weapon

**Crafting**: 1 Iron Ingot + 2 Sticks (vertical)

### 💰 Economy System

#### Turkish Lira (Türk Lirası)
**Purpose**: Currency for trading with Customer NPCs
**Stack Size**: 64
**Obtaining**: 
- Payment from satisfied customers
- Future: Selling to villagers
- Future: Loot from treasure chests

**Prices**:
- Chicken Döner Wrap: 15 Lira
- Lamb Döner Wrap: 20 Lira (premium)
- Beef Döner Wrap: 18 Lira

### 👥 NPCs

#### Customer Entity (Müşteri)
**Behavior**:
- Spawns near döner shops
- Generates random order on spawn
- Waits for up to 5 minutes (6000 ticks)
- Wanders around the area
- Displays order when right-clicked
- Pays with Turkish Lira when served
- Leaves satisfied after receiving order
- Despawns if not served in time

**Orders**:
Customers randomly order one of three döner wraps:
- Chicken Döner Wrap (15 Lira)
- Lamb Döner Wrap (20 Lira)
- Beef Döner Wrap (18 Lira)

**Attributes**:
- Health: 20 (10 hearts)
- Movement Speed: 0.25
- Follow Range: 16 blocks
- Passive entity (won't attack)
- Can swim
- Escapes danger

**Messages**:
- Order display: "Müşteri: [Item Name] istiyorum. Fiyat: [Price] lira"
- On payment: "Müşteri: Teşekkür ederim! İşte [Price] lira."

### 🎨 Localization

#### Supported Languages
1. **English (en_us)**
   - Complete translations
   - Item/block names
   - Container titles

2. **Turkish (tr_tr)**
   - Complete translations
   - Authentic Turkish names
   - Cultural accuracy

### ⚙️ Technical Features

#### Block Entities
- **DonerMachineBlockEntity**: 
  - Implements cooking logic
  - Tick-based processing
  - NBT data persistence
  - Client-side rotation animation
  
- **PreparationTableBlockEntity**:
  - Automatic crafting system
  - Flexible ingredient system
  - Inventory management

#### GUIs
- Custom screen handlers for each machine
- Slot restrictions (output slots are read-only)
- Quick-move (shift-click) support
- Custom textures

#### Rendering
- Block models with custom textures
- Item models with layer0 textures
- Transparent blocks (display counter)
- Custom VoxelShapes for collision

## Future Features (Planned)

### Gameplay
- ✨ Villager trading integration
- ✨ Döner shop structure generation
- ✨ Reputation system for repeat customers
- ✨ More customer variants with preferences
- ✨ Advanced shop decorations
- ✨ Customer queue system

### Agriculture
- ✨ Tomato crops
- ✨ Lettuce crops
- ✨ Onion crops
- ✨ Farming mini-game

### Expansion
- ✨ More döner varieties (mixed meat, vegetarian)
- ✨ Side dishes (fries, salad, soup)
- ✨ Drinks (ayran, cola, tea)
- ✨ Desserts (baklava, künefe)
- ✨ Shop upgrade system

### Technical
- ✨ Animated döner model (3D rotating meat)
- ✨ Sound effects (cooking, slicing, customers)
- ✨ Particle effects (steam, smoke)
- ✨ Integration with economy mods
- ✨ Multiplayer shop ownership

## Performance Notes

- All block entities use efficient tick-based processing
- Client-side rendering optimizations
- Minimal network traffic
- NBT data is compact and efficient
- No performance impact when blocks are not loaded

## Compatibility

- **Minecraft Version**: 1.20.1
- **Mod Loader**: Fabric
- **Dependencies**: Fabric API (required)
- **Conflicts**: None known
- **Recommended Mods**: 
  - JEI/REI for recipe viewing
  - Roughly Enough Items
  - Any structure generation mod
