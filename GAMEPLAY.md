# Gameplay Flow Diagram

## Döner Production Chain

```
┌─────────────────────────────────────────────────────────────────────────┐
│                          DÖNER PRODUCTION FLOW                          │
└─────────────────────────────────────────────────────────────────────────┘

STEP 1: GATHER INGREDIENTS
════════════════════════════
┌─────────────┐
│ Hunt Animals│
│ (Chicken,   │──┐
│  Sheep,     │  │
│  Cow)       │  │
└─────────────┘  │
                 │
┌─────────────┐  │
│ Farm Wheat  │  │
│ (for Pita)  │──┤
└─────────────┘  │
                 │
┌─────────────┐  │
│ Get Veggies │  │
│ (Creative/  │──┤
│  Trading)   │  │
└─────────────┘  │
                 │
                 ▼
┌─────────────────────────┐
│   BASIC INGREDIENTS     │
│  • 3x Raw Meat          │
│  • Wheat                │
│  • Vegetables           │
└─────────────────────────┘


STEP 2: CRAFT RAW DÖNER
═══════════════════════════
┌────────────────────┐
│  CRAFTING TABLE    │
│                    │
│   🥩 🥩 🥩         │──▶  ┌──────────────┐
│   Chicken/Lamb/    │     │ RAW DÖNER    │
│   Beef (3x same)   │     │ (1 piece)    │
└────────────────────┘     └──────────────┘


STEP 3: COOK THE DÖNER
══════════════════════════
┌────────────────────┐
│  DÖNER MACHINE     │
│  [Place Raw Döner] │
│                    │
│   INPUT: 🥩        │
│   TIME: 10 sec ⏱️  │
│   OUTPUT: 🍖       │──▶  ┌──────────────┐
│                    │     │ COOKED DÖNER │
│  (Auto-cooking     │     │ (1 piece)    │
│   with rotation    │     └──────────────┘
│   animation)       │
└────────────────────┘


STEP 4: SLICE THE MEAT
══════════════════════════
┌────────────────────┐
│  DÖNER KNIFE 🔪    │
│                    │
│  Right-click on    │
│  Döner Machine     │──▶  ┌──────────────┐
│  with cooked meat  │     │ SLICED MEAT  │
│                    │     │ (3 pieces!)  │
│  Durability: -1    │     └──────────────┘
└────────────────────┘


STEP 5: PREPARE THE WRAP
═════════════════════════════
┌─────────────────────────────────┐
│    PREPARATION TABLE            │
│                                 │
│  REQUIRED:                      │
│   🥩 Sliced Meat                │
│   🥖 Pita Bread                 │
│   🥬 Lettuce                    │
│   🍅 Tomato                     │
│                                 │
│  OPTIONAL:                      │
│   🧅 Onion                      │──▶  ┌─────────────────┐
│   🥒 Pickle                     │     │  DÖNER WRAP     │
│   🧄 Sauce (any type)           │     │                 │
│                                 │     │  Hunger: 12-14  │
│  ➡️ Auto-crafts when ready     │     │  Saturation: ★★ │
└─────────────────────────────────┘     └─────────────────┘


STEP 6: SERVE CUSTOMERS
═══════════════════════════
┌─────────────────────┐
│  CUSTOMER NPC 👤    │
│                     │
│  [Right-click]      │
│  Shows order:       │
│  "I want Chicken    │──▶  ┌──────────────────┐
│   Döner Wrap!"      │     │ Give the wrap    │
│  "Price: 15 Lira"   │     │                  │
│                     │     │ Receive payment: │
│  Timer: 5 minutes   │     │ 💰 Turkish Lira  │
└─────────────────────┘     └──────────────────┘
```

## Customer Interaction Flow

```
┌────────────────────────────────────────────────────────────────┐
│                    CUSTOMER LIFECYCLE                          │
└────────────────────────────────────────────────────────────────┘

    ┌──────────────┐
    │ Customer     │
    │ Spawns       │
    └──────┬───────┘
           │
           ▼
    ┌──────────────┐
    │ Generates    │
    │ Random Order │
    │ • Chicken 🐔 │
    │ • Lamb 🐑    │
    │ • Beef 🐄    │
    └──────┬───────┘
           │
           ▼
    ┌──────────────┐
    │ Wanders      │
    │ Near Shop    │
    │              │
    │ Timer: 5 min │
    └──────┬───────┘
           │
           ├────────────────────┐
           │                    │
           ▼                    ▼
    ┌──────────────┐     ┌─────────────┐
    │ Player       │     │ Timer       │
    │ Right-clicks │     │ Expires     │
    └──────┬───────┘     └──────┬──────┘
           │                    │
           ▼                    ▼
    ┌──────────────┐     ┌─────────────┐
    │ Shows Order  │     │ Customer    │
    │ + Price      │     │ Leaves      │
    └──────┬───────┘     │ (Unhappy)   │
           │             └─────────────┘
           ▼
    ┌──────────────┐
    │ Player Gives │
    │ Correct Wrap?│
    └──────┬───────┘
           │
    ┌──────┴───────┐
    │ YES   │  NO  │
    ▼              ▼
┌───────────┐  ┌──────────┐
│ Pays Lira │  │ Rejected │
│ 15-20 💰  │  │ (Try     │
│           │  │  again)  │
└─────┬─────┘  └──────────┘
      │
      ▼
┌───────────┐
│ Customer  │
│ Leaves    │
│ (Happy!)  │
│ "Teşekkür"│
│ "ederim!" │
└───────────┘
```

## Shop Setup Flow

```
┌────────────────────────────────────────────────────────────────┐
│                    BUILDING YOUR SHOP                          │
└────────────────────────────────────────────────────────────────┘

PHASE 1: CRAFTING EQUIPMENT
════════════════════════════
Iron Ingots x8 + Furnace
        ↓
  ┌─────────────┐
  │ DÖNER       │
  │ MACHINE     │
  └─────────────┘

Planks x3 + Slabs x3
        ↓
  ┌─────────────┐
  │ PREPARATION │
  │ TABLE       │
  └─────────────┘

Glass Panes x3 + Planks x3
        ↓
  ┌─────────────┐
  │ DISPLAY     │
  │ COUNTER     │
  └─────────────┘

Iron Ingot + Sticks x2
        ↓
  ┌─────────────┐
  │ DÖNER       │
  │ KNIFE       │
  └─────────────┘


PHASE 2: SHOP LAYOUT
════════════════════════

    ┌─────────────────────────────────┐
    │         YOUR DÖNER SHOP         │
    │                                 │
    │  🪟🪟🪟  [Display Counters]     │
    │                                 │
    │  🍖     [Döner Machine]         │
    │                                 │
    │  📦     [Preparation Table]     │
    │                                 │
    │  👤     [Customer Area]         │
    │                                 │
    └─────────────────────────────────┘


PHASE 3: OPERATION
══════════════════════
1. Place raw döner in machine
2. Wait for cooking
3. Slice with knife
4. Combine ingredients on table
5. Wait for customers
6. Serve orders
7. Collect payment
8. Repeat!
```

## Economic Flow

```
┌────────────────────────────────────────────────────────────────┐
│                    MONEY MAKING SYSTEM                         │
└────────────────────────────────────────────────────────────────┘

COSTS (Approximate)
═══════════════════
Materials Gathering
    ↓
Raw Meat Collection (Free if hunting)
    ↓
Crafting (No cost)
    ↓
TOTAL INVESTMENT: Minimal


REVENUE
═══════════════════
Chicken Wrap: 15 Lira  💰💰💰
Lamb Wrap:    20 Lira  💰💰💰💰
Beef Wrap:    18 Lira  💰💰💰

PROFIT MARGIN: Very High! ✨


SCALING
═══════════════════
More Machines = More Production
    ↓
More Customers = More Sales
    ↓
Build Döner Empire! 🏪🏪🏪
```

## Quick Start Guide

```
┌────────────────────────────────────────────────────────────────┐
│                  5-MINUTE QUICK START                          │
└────────────────────────────────────────────────────────────────┘

⏱️ MINUTE 1-2: GATHER
━━━━━━━━━━━━━━━━━━━━━
Kill 6 chickens → Get raw chicken
Mine iron → Get 8 ingots
Get a furnace

⏱️ MINUTE 2-3: CRAFT
━━━━━━━━━━━━━━━━━━━━━
Craft Döner Machine
Craft Döner Knife
Craft 2x Raw Chicken Döner

⏱️ MINUTE 3-4: COOK
━━━━━━━━━━━━━━━━━━━━━
Place raw döner in machine
Wait 10 seconds × 2
Slice with knife → 6 sliced meat

⏱️ MINUTE 4-5: PREPARE
━━━━━━━━━━━━━━━━━━━━━
Get vegetables (creative/trade)
Craft pita bread
Use preparation table

⏱️ MINUTE 5+: PROFIT!
━━━━━━━━━━━━━━━━━━━━━
Wait for customers
Serve orders
Collect Liras
Expand business! 🚀
```

---

**Legend:**
🥩 = Meat    🥖 = Bread   🥬 = Lettuce  🍅 = Tomato
🧅 = Onion   🥒 = Pickle  🧄 = Sauce    🔪 = Knife
👤 = Customer 💰 = Money   🍖 = Cooked   ⏱️ = Time
