# M320 – Program Logic of Every Task

This file explains **how each exercise works when it runs**: which class does
what, in what order the methods are called, and why the code is built that way.
`Code_Summary.txt` lists the classes; this file follows the program flow.

| Folder | Start class | Main topic |
|---|---|---|
| `D1_Heizung_Aufgabe` | `ch.Main` | Classes, encapsulation, input loops |
| `V1_Spezialklassen_Employee` | `Ch.Main` | Inheritance, overriding |
| `V2_Fussball_Mannschaft` | `Ch.MainV2` | Overriding, polymorphism |
| `V3_Waffen_Interface` | `Ch.MainV3` | Interface, aggregation, Strategy pattern |
| `D2_Flug_Passagiere` | `Ch.MainD2` | 1:n relationship, delegation, polymorphism |
| `Q3_HashMap` | `Ch.MainQ3`, `Ch.StackDemoQ3` | HashMap, CSV file, own generic stack interface |

V3, D2 and Q3 share the same layered structure:

```
Main  ->  Menu (reads input, catches exceptions)  ->  Model classes (data + logic)
```

`main` only builds the starting objects and hands them to the menu. The menu
runs a `while (running)` loop, reads one line, and uses a `switch` to call a
private helper method. Each helper throws its own exception class when the input
is wrong, and the menu catches it in **one** `try/catch` around the `switch`.
It prints the message and shows the menu again, so the program never crashes
because of bad input.

---

## D1 – Heater (`D1_Heizung_Aufgabe`)

**Goal:** control several heaters whose temperature can only move in fixed
steps inside a min..max range.

### Classes
- **`Heater`**: private fields `temperature`, `min`, `max`, `increment` with
  getters and setters (encapsulation). It also holds the two interactive methods.
- **`Main`**: creates the heaters and runs the outer program loop.

### Flow
1. `main` creates three heaters and puts them in an array:

   | # | start | min | max | step |
   |---|---|---|---|---|
   | 1 | 19 | 0 | 35 | 1 |
   | 2 | 20 | 3 | 40 | 5 |
   | 3 | 30 | 4 | 40 | 9 |

   One `Scanner` is created for the whole program and closed at the end.
2. **Outer loop** (`while (programRunning)`):
   1. `Heater.selectHeater(heaters, scanner)` (static) prints all heaters as
      1..3. It reads a line, converts it with `Integer.parseInt(input) - 1` to
      an array index, and repeats until the index is valid. A non-number causes
      a `NumberFormatException`; the catch sets the choice to `-1`, so the loop
      asks again.
   2. `selected.userInput(scanner)` runs the **inner loop** on that one heater:
      - shows the current values and reads `+` or `-`
      - `+` is only applied if `temperature + increment <= max`;
        `-` only if `temperature - increment >= min`. The check happens
        **before** the change, so the value can never leave the range.
      - in every other case it prints "Range limits crossed". This includes
        input that is neither `+` nor `-`.
      - then it asks "continue?": `0` ends the inner loop, `1` or anything
        else goes round again (anything else also prints "Invalid input").
   3. Back in `main`: "another heater (1) or quit (0)". `1` jumps back to the
      heater selection and `0` sets `programRunning = false`. Any other answer
      enters a small `while` that keeps asking until the answer is `0` or `1`.
3. After the loop the scanner is closed.

**Example:** heater 3 is at 30 with step 9. `+` would make it 39, which is
≤ 40, so the change is allowed. A second `+` would make it 48, so it is refused.

---

## V1 – Employees (`V1_Spezialklassen_Employee`)

**Goal:** model different kinds of employees that share common data but
calculate their pay differently (inheritance and overriding).

### Class hierarchy
```
Employee  (name, id, salary, hours; calculatePay() = salary * hours)
 ├── FullTimeEmployee  (+ hourly_rate, hours_worked, hasBonus, Bonus)
 ├── PartTimeEmployee  (+ hourly_rate, hours_worked)
 └── Intern            (+ maxHours = 50)
EmployeeManager        (one ArrayList per subclass)
```

Each subclass calls `super(name, id, salary, hours)` in its constructor, so the
common fields live in `Employee` and stay `private`. Subclasses reach them only
through getters and setters such as `getId()`, `getSalary()` and `setHours()`.

### How each type calculates its pay
| Class | Own method | `calculatePay()` (override) |
|---|---|---|
| `Employee` | – | `salary * hours` |
| `PartTimeEmployee` | `calculate_rate()` = `hourly_rate * hours_worked` | returns `calculate_rate()` |
| `FullTimeEmployee` | `calculate_pay()` = `hourly_rate * hours_worked` | `calculate_pay()` + `Bonus` **if** `hasBonus` |
| `Intern` | `internWageCalc()` | returns `internWageCalc()` |

`internWageCalc()` first checks `getHours() > maxHours`. If so, it **sets the
hours back to 50** with `setHours`. This is a permanent change to the object.
It then returns the fixed wage (= `salary`), which does not depend on the hours.

Every method also prints a block with id, name and amount.

### Flow of `main`
**Task 1:** one object per type. Each one calls its *own* specific method:

| Object | Call | Result |
|---|---|---|
| Jessika (`Employee`) | `calculatePay()` | 300000 × 40 = 12,000,000 |
| Paul (`PartTimeEmployee`) | `calculate_rate()` | 400 × 999 = 399,600 |
| Mother (`FullTimeEmployee`) | `calculate_pay()` | 555 × 555 = 308,025 (without bonus) |
| Alina (`Intern`) | `internWageCalc()` | 56 h > 50 → hours set to 50, wage 44,444 |

**Task 2:** an `EmployeeManager` gets Paul, Mother and Alina through
`addPartTimeEmployee`, `addFullTimeEmployee` and `addIntern`. Then
`printAllPays()` loops over the three lists and calls `calculatePay()` on each
object:
- Paul → 399,600 again
- Mother → 308,025 **plus** bonus 5,000 = **313,025** (now the override with bonus runs)
- Alina → 44,444. The "hours set to 50" message does **not** appear again,
  because task 1 already changed her hours to 50.

The manager needs three separate lists because each list has a concrete
subclass type. V2 shows the better solution: one list of the superclass type.

**Note:** Jessika is a plain `Employee`, so the manager has no list for her.
`FullTimeEmployee` and `PartTimeEmployee` inherit `salary` and `hours` but
calculate with their own `hourly_rate`/`hours_worked`, so the inherited values
are not used.

---

## V2 – Football Team (`V2_Fussball_Mannschaft`)

**Goal:** different player roles react differently to the same call
(`play()`). This is polymorphism through overriding.

### Classes
- **`Team`**: the superclass of every player, despite its name. It holds:
  - instance data: `namePlayer`, `role`, `team`
  - **static** shared data: `scanner` (one for the whole program),
    `players` (`ArrayList<Team>`) and `listTeam` (all team names)
  - `play()`: prints "*name* (team *X*) runs onto the pitch."
  - static helpers `listTeamName()`, `playAll()`, `createNewTeam()` and
    `createNewPlayer()`
- **`Goalie`, `Defender`, `Striker`**: `extends Team`. Each overrides `play()`.
  It first calls `super.play()` (the general line) and then prints its own role
  line. `Goalie` also overrides `showName()` to add "(Goalie)", and `Striker`
  adds `jogTraining()`.
- **`Menu`**: `extends Team`, but only to use its static members. It holds the
  static `userMenu()` loop.
- **`MainV2`**: sets up the start data.

### Flow
1. `main` adds the team "FC Zurich" to `listTeam` and adds three players to
   `players`: `Goalie` Yann, `Defender` Manuel and `Striker` Breel. All three
   are stored in the **same** `ArrayList<Team>` because each of them *is a*
   `Team`.
2. `Menu.userMenu()` loops:
   - `scanner.nextInt()` reads the choice, then `scanner.nextLine()` removes
     the leftover Enter. If the input is not a number, an
     `InputMismatchException` is thrown. The catch prints "Invalid input!" and
     calls `nextLine()` to throw away the bad input, otherwise the loop would
     spin forever.
   - **1 `listTeamName()`**: for each team name, loop over all players and
     call `showName()` on those with `player.team.equals(teamName)`. The Goalie
     prints with "(Goalie)" because of its override.
   - **2 `createNewPlayer()`**: reads name, team and role (`1`/`2`/`3`). The
     role decides which subclass is created
     (`new Goalie(...)` / `Defender` / `Striker`). With an invalid role the
     method returns early, so **neither** the player nor the new team is saved.
     With a valid role the team is added to `listTeam` if it is new, and the
     player goes into `players`.
   - **3 `createNewTeam()`**: reads a name and adds it only if
     `!listTeam.contains(name)` (no duplicates).
   - **4 `playAll()`**: `for (Team player : players) player.play();`. The
     variable type is `Team`, but Java calls the `play()` of the **actual**
     object at runtime (dynamic binding). The result is that each player prints
     the general line followed by its own role line.
   - **5**: sets `flag = false` and ends the loop.

**Notes:**
- `Goalie.createNewTeam()` and `createNewPlayer()` are static, so they *hide*
  the `Team` methods instead of overriding them. That is why `@Override` is
  commented out.
- `jogTraining()` and `bodySize` exist but are never used.

---

## V3 – Weapons with an Interface (`V3_Waffen_Interface`)

**Goal:** give characters exchangeable weapons **without** a subclass for every
character/weapon combination. This is the **Strategy pattern**: composition
instead of inheritance.

### Classes
```
<<interface>> WeaponBehavior { void useWeapon(); }
   ├── SwordBehavior   -> "swings a heavy sword."
   ├── StaffBehavior   -> "casts a fireball with the magic staff."
   └── DaggerBehavior  -> "stabs quickly with a dagger."

GameCharacter (characterName, WeaponBehavior weaponBehavior)   <- HAS-A
   ├── Warrior  -> super(name, new SwordBehavior())
   ├── Mage     -> super(name, new StaffBehavior())
   └── Rogue    -> super(name, new DaggerBehavior())
```

- `GameCharacter.fight()` prints "*name* (*ClassName*) fights:" and then calls
  `weaponBehavior.useWeapon()`. The character does not know *which* weapon it
  holds; it only knows the interface. This is **delegation**.
- `setWeaponBehavior()` swaps the weapon object while the program is running.
- `GameCharacter` is `abstract` with a `protected` constructor, so only a
  `Warrior`, `Mage` or `Rogue` can be created, never a character without a type.
- The subclasses only choose a **default weapon** in their constructor. They do
  not override `fight()`.
- The class is named `GameCharacter` because `Character` already exists in
  `java.lang`.

### Flow
1. `MainV3` creates the list with Conan (Warrior), Gandalf (Mage) and Garrett
   (Rogue) and starts `CharacterMenu.userMenu()`.
2. Menu options:
   - **1 `createCharacter()`**: reads the type first and checks it right away
     (must be `1`, `2` or `3`, otherwise it throws `CharacterInputException`).
     Then it reads the name (empty name → exception). A `switch` creates the
     matching subclass and adds it to the list.
   - **2 `listCharacters()`**: prints `index + 1`, the name, and
     `getClass().getSimpleName()`, which gives the real class name at runtime.
   - **3 `fightAll()`**: `walk()` and `fight()` for every character.
   - **4 `changeWeapon()`**:
     1. lists the characters and returns if there are none
     2. reads a number. `parseInt` failing (`NumberFormatException`) is turned
        into a `CharacterInputException`, and so is an index out of range
     3. reads the weapon `1`/`2`/`3` and calls `setWeaponBehavior(new ...)`.
        Any other input → exception, nothing changes
     4. calls `fight()` straight away to show the new weapon. A Mage with a
        sword now "swings a heavy sword". No new class was needed.
   - **5**: exit.
3. Every exception from the helpers is caught by the single `try/catch` in
   `userMenu()`, which prints the message and keeps looping.

**Why this design:** with overriding you would need classes like
`WarriorWithStaff`, `MageWithSword` and so on. With the interface, a new weapon
is **one** new class that implements `WeaponBehavior`, and every character can
use it at once.

---

## D2 – Flight and Passengers (`D2_Flug_Passagiere`)

**Goal:** a 1:n relationship. One flight has many passengers, and the flight
lets each passenger do its own part of the work (delegation). Passengers travel
in different classes, and the flight treats all of them the same way
(polymorphism).

### Classes
```
Passenger  (abstract: name; printBoardingInfo();
            abstract getTravelClass(), getBaggageAllowanceKg())
 ├── EconomyPassenger   -> "Economy", 23 kg
 └── BusinessPassenger  -> "Business", 32 kg, overrides printBoardingInfo()
                           to add "priority boarding"
```
- **`Passenger`**: `abstract`, so a passenger always has a travel class.
  `printBoardingInfo()` prints "*name* (*class*, *n* kg baggage)". It calls the
  two abstract methods, and each subclass answers them in its own way.
- **`EconomyPassenger`, `BusinessPassenger`**: each returns its class name and
  its baggage allowance (a `private static final` constant). `BusinessPassenger`
  also overrides `printBoardingInfo()`: it calls `super.printBoardingInfo()` and
  then adds a "priority boarding" line.
- **`Flight`**: `flightNumber` and `List<Passenger> passengers`
  (initialised empty, which is the 1:n HAS-A link). The list type is the
  superclass, so it holds economy and business passengers together.
  - `addPassenger(p)`: adds `p` to the list.
  - `removePassenger(name)`: searches with `equalsIgnoreCase`, removes the
    **first** match and returns `true` straight away. Returning at once matters
    because changing a list while a for-each loop is still running over it
    throws `ConcurrentModificationException`. Returns `false` if no passenger
    matched.
  - `printPassengerList()`: prints a header and "No passengers yet." if the
    list is empty. Otherwise it calls `passenger.printBoardingInfo()` for each
    passenger and prints the total baggage allowance at the end. The flight
    does not print the passengers itself; it **delegates** this to each one.
    The variable type is `Passenger`, but Java runs the method of the
    **actual** object (dynamic binding), so a business passenger also prints
    its "priority boarding" line.
  - `getTotalBaggageAllowanceKg()`: adds up `getBaggageAllowanceKg()` of all
    passengers. Each one returns the allowance of its own class (polymorphism).
  - `getPassengers()`: returns a read-only view of the list, so passengers can
    only be added or removed through the flight.
- **`FlightMenu`**: the console menu. **`FlightInputException`**: the error
  type for bad input.
- **`MainD2`**: creates `new Flight("LX318")` and starts the menu.

### Flow
Menu loop with `switch (scanner.nextLine().trim())`:
- **1 book**: reads the name. Empty → `FlightInputException("Name must not be
  empty.")`. Then it reads the travel class (`1` = Economy, `2` = Business).
  `createPassenger()` uses a `switch` to create the matching subclass; any other
  input → `FlightInputException`, and nobody is booked. Then
  `flight.addPassenger(passenger)` and a confirmation with the travel class.
- **2 remove**: reads the name and prints "removed" or "not found" based on
  the `boolean` that `removePassenger` returns.
- **3 list**: `flight.printPassengerList()`.
- **4 exit**: prints a goodbye and ends the loop.
- anything else → `FlightInputException("Invalid choice")`, caught in the menu.

The same name can be booked twice. Removing then deletes only one of them.

---

## Q3 – HashMap with Airports (`Q3_HashMap`)

**Goal:** store key → value pairs (airport code → airport name) in a
`HashMap`, load them from a CSV file, and build a simple generic data structure
(a stack).

### Classes
- **`AirportMap`**: wraps a `HashMap<String, String>` and passes each call on
  to it:
  - `put(code, name)` returns the **old** value, or `null` if the code was new.
    Keys are unique, so putting an existing code replaces its name.
  - `get(code)` returns the name, or `null` if the code is not found.
  - `containsKey`, `size`, `clear`, and `printAll` (loops over `keySet()`; a
    `HashMap` has no fixed order).
- **`AirportFileReader.readFile(fileName, map)`**:
  1. `Files.readAllLines(...)` reads the whole file (UTF-8). If the file cannot
     be read, this throws `IOException`, which is passed on to the caller.
  2. The loop starts at index **1** to skip the header
     `AIRPORT CODE,AIRPORT`.
  3. For each line: trim it, skip empty lines, then `split(",", 2)`. The `2`
     means it splits only at the **first** comma, so a name may contain commas.
  4. No comma or an empty code → print "Line *n* skipped" and continue.
  5. The code is changed to upper case. `map.put` returns non-null for a
     duplicate code, so the reader reports the replaced name with its line number.
- **`AirportMenu`**: the console menu. Its static `load(fileName, map)` calls
  the reader and prints the new map size. If an `IOException` happens, it prints
  the **absolute path** so the user can see where the program looked for the file.
- **`AirportInputException`**: the error type for bad menu input.
- **`MainQ3`**: `DEFAULT_FILE = "airports.csv"`. This path is relative to the
  working directory, which is the project folder in IntelliJ.

### Flow of `MainQ3`
1. Create an empty `AirportMap` and call `AirportMenu.load(DEFAULT_FILE, map)`
   to fill it with about 155 airports.
2. Menu loop:
   - **1 search**: input is trimmed and changed to upper case, so `jfk` finds
     `JFK`. `get` returning `null` → "No airport found".
   - **2 show all**: `printAll()`.
   - **3 add/replace**: the code must be exactly 3 characters, checked
     **before** asking for the name. The name must not be empty. Otherwise an
     `AirportInputException` is thrown. The return value of `put` decides
     between "was added" and "already existed, … was replaced".
   - **4 load file**: reads a file name; Enter alone means the default file.
     The entries are added to the existing map (it is not cleared first).
   - **5 exit**.

### `SimpleStack<T>`, its two implementations and `StackDemoQ3` (second `main`)
```
<<interface>> SimpleStack<T> { push, pop, peek, size; default isEmpty() }
   ├── ArrayStack<T>   -> elements in an ArrayList<T>, top = end of the list
   └── LinkedStack<T>  -> chain of nodes, each node knows the node below it
```
- `SimpleStack<T>` is a generic **LIFO** interface. It only says *what* a stack
  can do. `isEmpty()` is a `default` method (`size() == 0`), so the classes
  don't have to write it themselves. `T` is chosen when the stack is created,
  e.g. `new ArrayStack<String>()`.
- `ArrayStack<T>`: `push` → `add` to the end, `pop` → `remove(size - 1)`,
  `peek` → `get(size - 1)`.
- `LinkedStack<T>`: stores only the `top` node. `push` creates a new node whose
  `below` is the old top. `pop` takes the element of the top node and makes
  `top.below` the new top. A counter keeps `size()` fast.
- In both, `pop` or `peek` on an empty stack → `EmptyStackException`.
- `StackDemoQ3`:
  1. Loads the CSV into a map.
  2. Calls `flyRoundTrip(new ArrayStack<>(), map)` and then
     `flyRoundTrip(new LinkedStack<>(), map)`. The parameter type is
     `SimpleStack<String>`, so the demo doesn't know which class it gets
     (polymorphism through the interface). Both runs print the same result,
     with only the class name in the header being different.
  3. **Outbound trip** (`flyOutbound`): goes through `TRIP =
     {"JFK","ORD","ZRH","DEN","LAX"}` and pushes only codes that `containsKey`
     finds. ZRH is not in the file, so it is skipped. The stack becomes JFK,
     ORD, DEN, LAX (LAX on top). `peek()` then shows LAX without removing it.
  4. **Way back** (`flyBack`): `while (!isEmpty()) pop()` returns
     LAX → DEN → ORD → JFK, the reverse order (last in, first out).
  5. One more `pop()` on the now empty stack throws `EmptyStackException`. The
     demo catches it and prints "you are back home".

---

## Concepts at a Glance

| Concept | Where it is shown |
|---|---|
| Encapsulation (private + getters/setters) | all tasks, clearest in D1 `Heater` |
| Inheritance (`extends`, `super(...)`) | V1 `Employee`, V2 `Team`, V3 `GameCharacter`, D2 `Passenger` |
| Abstract class / method | V3 `GameCharacter`, D2 `Passenger` (`getTravelClass()`, `getBaggageAllowanceKg()`) |
| Overriding (`@Override`) | V1 `calculatePay()`, V2 `play()` / `showName()`, D2 `printBoardingInfo()` |
| Polymorphism (dynamic binding) | V2 `playAll()`, V3 `useWeapon()`, D2 `printPassengerList()` / `getTotalBaggageAllowanceKg()`, Q3 `flyRoundTrip(SimpleStack<String>)` |
| Interface | V3 `WeaponBehavior`, Q3 `SimpleStack<T>` (with a `default` method) |
| Aggregation / HAS-A | V3 character has a weapon, D2 flight has passengers |
| Delegation | V3 `fight()` → `useWeapon()`, D2 `printPassengerList()` → `printBoardingInfo()`, Q3 `AirportMap` → `HashMap` |
| Own exception classes | V3, D2, Q3 (`...InputException extends Exception`) |
| Collections | `ArrayList` everywhere, `HashMap` in Q3 |
| Own generic types | Q3 `SimpleStack<T>`, `ArrayStack<T>`, `LinkedStack<T>` |

V1 `printAllPays()` only uses **overriding**: each list has a concrete
subclass type, so no method is called through an `Employee` variable. It is
not an example of polymorphism.
| File input | Q3 `AirportFileReader` (`Files.readAllLines`, `IOException`) |
