# WerseRokRewards – Daily Tasks (Minecraft Plugin)

Plugin do **zliczania postępu zadań dziennych** gracza i nagradzania go za ukończenie celów.

## Opis
Plugin monitoruje aktywności gracza i sprawdza, czy wykonał **dzienne zadania**.  
Po aktualizacji dowolnego zadania wyświetlany jest **progress bar**, a po ukończeniu zadania odpalane są **fajerwerki**.

## Śledzone zadania dzienne
Plugin zlicza m.in.:

- ✅ **Zniszczone bloki** (blocks broken)
- ✅ **Scraftowane przedmioty/bloki** (items crafted)
- ✅ **Ilość zaklętych broni** (enchanted weapons)
- ✅ **Ilość rozmnożonych zwierząt** (animals bred)
- ✅ **Ilość tradów z villagerami** (villager trades)

> W projekcie znajduje się głównie **logika zliczania** oraz integracja z **PlaceholderAPI**.

## Funkcje
- 📊 Zliczanie postępu dla każdego zadania dziennego
- 📌 Integracja z **PlaceholderAPI** (placeholdery do wyświetlania postępu)
- 🟩 **Progress bar** wyświetlany przy aktualizacji zadania
- 🎆 **Fajerwerki** po ukończeniu konkretnego zadania

## PlaceholderAPI

Plugin udostępnia placeholdery umożliwiające wyświetlanie postępu zadań dziennych
(np. na scoreboardzie, bossbarze lub w innych pluginach wspierających PlaceholderAPI).

### Dostępne placeholdery

| Placeholder | Opis |
|------------|------|
| `%werse-rok-rewards_mining%` | Ilość zniszczonych bloków |
| `%werse-rok-rewards_killing%` | Ilość zabitych mobów |
| `%werse-rok-rewards_trading%` | Ilość trade’ów z villagerami |
| `%werse-rok-rewards_crafting%` | Ilość scraftowanych przedmiotów |
| `%werse-rok-rewards_enchants%` | Ilość zaklętych przedmiotów |
| `%werse-rok-rewards_breads%` | Ilość rozmnożonych zwierząt |

### Jak to działa
Placeholdery są aktualizowane automatycznie wraz z postępem gracza.
Gdy gracz wykona część zadania:
- aktualizowany jest progress bar
- po ukończeniu zadania uruchamiane są fajerwerki

## Wymagania
- Serwer: **Spigot/Paper**
- (Opcjonalnie) **PlaceholderAPI** – jeśli chcesz używać placeholderów

## Instalacja
1. Wrzuć plik `.jar` do folderu `plugins/`
2. Zrestartuj serwer
3. (Opcjonalnie) Zainstaluj PlaceholderAPI, jeśli chcesz używać placeholderów

## Działanie
- Gdy gracz zrobi postęp w zadaniu → pokazuje się progress bar
- Gdy gracz ukończy zadanie → odpalane są fajerwerki

## Status
Projekt w trakcie rozwoju – skupiony głównie na logice i integracji z placeholderami.
