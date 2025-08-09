# Changelog

All notable changes to this project will be documented in this file.

## [1.1.9+mc1.21.4] - 2024-08-09

### Changed
- **Code Optimization**: Cleaned and optimized all Java source files
- **Removed Comments**: Removed all unnecessary comments for cleaner code
- **Better Performance**: Optimized imports and removed redundant code
- **Professional Polish**: Final code cleanup for production release

### Technical
- Streamlined all class implementations
- Removed verbose comments and documentation from source code
- Optimized import statements across all files
- Enhanced code readability through consistent formatting

## [1.1.8+mc1.21.4] - 2024-08-09

### Changed
- **Authors Section**: Moved Igr0man1y3_2 to authors list instead of description
- **License Display**: Updated license display to match project format (GPL v2)
- **Clean Description**: Removed author attribution from mod description for cleaner look

### Technical
- Updated fabric.mod.json authors array to include both Makev1ch and Igr0man1y3_2
- Enhanced README with proper authors and license information in Development section

## [1.1.7+mc1.21.4] - 2024-08-09

### Added
- **Issues Link**: Added proper bug tracker link in ModMenu for easy issue reporting
- **GPL v2 License**: Changed license from MIT to GNU General Public License v2
- **Dependencies Info**: Clear requirements section in README for Fabric API and ModMenu
- **Idea Attribution**: Credited Igr0man1y3_2 as the original idea author

### Changed
- **Improved Description**: Updated mod description to mention configurable key instead of fixed F6
- **Better Documentation**: Enhanced installation instructions with clear requirements
- **Professional Polish**: Final touches for a complete mod experience

### Technical
- Updated fabric.mod.json with issues URL for ModMenu integration
- License change to GPL-2.0-only for better open source compatibility
- Enhanced metadata with proper attribution

## [1.1.6+mc1.21.4] - 2024-08-09

### Changed
- **Improved Config UI**: Title is now displayed as regular text instead of a button
- **Unified Design**: ModMenu integration now uses the same clean interface as built-in config
- **Better Layout**: Cleaner spacing and visual hierarchy in settings screen

### Technical
- Simplified ModMenu integration to use native config screen
- Removed unused Cloth Config dependencies from ModMenu integration
- Enhanced visual consistency across all config access methods

## [1.1.5+mc1.21.4] - 2024-08-09

### Added
- **Built-in Config Screen**: Independent settings screen accessible without ModMenu
- **Config Key Binding**: New configurable key (N by default) to open mod settings
- **Standalone Functionality**: Full mod configuration available even without ModMenu installed
- **Native Settings UI**: Clean, simple settings interface using vanilla Minecraft UI elements

### Technical
- Added `FreeCursorConfigScreen` class for independent configuration
- Registered new key binding for config access
- Maintained full compatibility with existing ModMenu integration
- Enhanced key binding system with dual key support

## [1.1.4+mc1.21.4] - 2024-08-09

### Added
- **Disable Blur Setting**: New option to remove background blur when cursor is freed
- **Smart Blur Management**: Automatically saves and restores original blur settings
- **Perfect for Screenshots**: Clean background without blur for better visual quality

### Technical
- Added blur state management system
- Integration with Minecraft's `MenuBackgroundBlurriness` option
- Automatic restoration of user's original blur preferences

## [1.1.3+mc1.21.4] - 2024-08-09

### Changed
- **Replaced Black Screen**: Removed black screen option, replaced with F1 simulation
- **New Simulate F1 Setting**: Option to hide HUD elements when cursor is freed, exactly like pressing F1
- **Better World Visibility**: Perfect for screenshots and enjoying the Minecraft world view
- **Smart State Management**: Preserves original F1 state and restores it when closing

### Added
- F1 simulation functionality for HUD hiding
- Automatic state preservation and restoration
- Proper integration with Minecraft's built-in hideGui option

### Technical
- Updated configuration system to use `simulateF1` instead of `showBlackScreen`
- Added state management for original F1 setting
- Updated localization keys and tooltips

## [1.1.2+mc1.21.4] - 2024-08-09

### Changed
- **Replaced Interface Toggle**: Removed text overlay setting, replaced with black screen option
- **New Black Screen Setting**: Option to show black screen that hides all game elements
- **Clean Screen**: FreeCursor screen now always shows clean transparent overlay without any text
- **Simplified Approach**: Removed complex mixins, using simple overlay system

### Added
- Black screen overlay option for complete game hiding
- Simple and reliable screen covering system

### Technical
- Updated configuration system to use `showBlackScreen` instead of `showInterface`
- Removed all mixins for better compatibility
- Updated localization keys and tooltips

## [1.1.1+mc1.21.4] - 2024-08-09

### Added
- **ModMenu Integration**: Added configuration screen accessible through ModMenu
- **Interface Toggle Setting**: New option to show/hide interface overlay when cursor is freed
- **Config System**: JSON-based configuration system for persistent settings
- **Cloth Config Integration**: Modern configuration UI using Cloth Config
- **Localization Updates**: Added new translation keys for config options

### Changed
- **Screen Logic**: Interface overlay now controlled by user setting (disabled by default)
- **Dependencies**: Updated ModMenu and Cloth Config to latest versions
- **Build System**: Added new repositories for dependencies

### Technical
- Added `FreeCursorConfig` class for configuration management
- Added `FreeCursorModMenuIntegration` for ModMenu compatibility
- Configuration saved to `config/freecursor.json`

## [1.1.0+mc1.21.4] - 2024-08-09

### Added
- Initial release with clean cursor release screen
- Updated versioning system with MC version suffix

## [1.0.0] - 2024-08-09

### Added
- Initial release
- F6 key binding to free cursor (configurable)
- Clean transparent screen when cursor is freed
- LMB/ESC to return to game
- Localization support (English/Russian)
- Client-side only mod
