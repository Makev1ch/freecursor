# FreeCursor

**FreeCursor** is a Minecraft mod that allows you to temporarily free your mouse cursor during gameplay by pressing a key.

## Features

- 🎮 **Customizable Key**: F6 by default, but can be changed in game settings
- 🖱️ **Simple Cursor Release**: Press the key to free your cursor
- ↩️ **Easy Return**: Click LMB or press ESC to return to the game
- 🌍 **Localization**: Support for Russian and English languages
- ⚡ **Client-side Only**: No server installation required

## Installation

    Requires:
        Fabric Loader + Fabric API.
        Optional: ModMenu (for GUI settings).
    Steps:
        Place .jar in mods folder.
        Launch Minecraft.

## Usage

1. Press **F6** (or your configured key) during gameplay
2. The cursor will be freed and you can move it outside the game window
3. To return to the game:
   - Click **Left Mouse Button** anywhere
   - Or press **ESC**

## Configuration

### Key Bindings
To change keys:
1. Open **Settings** → **Controls**
2. Find the **FreeCursor** category
3. Set your desired keys:
   - **Free Cursor** (default: F6) - Release cursor
   - **Open FreeCursor Config** (default: N) - Open mod settings

### Mod Settings
Access mod settings in two ways:

#### Option 1: Built-in Config (No ModMenu required)
1. Press **N** key (or your configured key) during gameplay
2. Built-in settings screen will open
3. Toggle settings and press **Done**

#### Option 2: ModMenu Integration (if ModMenu is installed)
1. Install [ModMenu](https://modrinth.com/mod/modmenu)
2. Open **Mods** menu in game
3. Find **FreeCursor** and click **Configure**

#### Available Settings:
- **Simulate F1**: Hide HUD elements when cursor is freed (just like pressing F1)
- **Disable Blur**: Remove background blur when cursor is freed

## Compatibility

- **Minecraft**: 1.21.4+
- **Fabric Loader**: 0.16.0+
- **Java**: 21+
- **Optional**: [ModMenu](https://modrinth.com/mod/modmenu) for in-game configuration
