# DominionCore (Origins Branch)

Initial Fabric scaffolding for DominionCore with:

- Core mod initializer
- Client initializer
- Keybinding registration
- First custom full-screen panel for Dominion Manager
- Reusable GUI core utilities (palette, panel renderer, animator)

## Quick start

1. Install JDK 17.
2. Generate Gradle wrapper if needed (`gradle wrapper`).
3. Run client (`./gradlew runClient`).
4. In-game, press `K` to open the Dominion Manager prototype GUI.

## Next implementation targets

- Bloodline selection screen (with lock-state logic)
- Graph-based skill tree renderer
- JSON-driven node definitions
- DominionScript parser/runtime skeleton
- Faction/religion state containers + sync packets
