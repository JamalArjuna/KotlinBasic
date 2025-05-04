package GameTerminal


class Weapon{
    lateinit var weaponName: String
    var attackPower: Double = 0.0

    constructor(WeaponName: String, AttackPower: Double){
        this.weaponName = WeaponName
        this.attackPower = AttackPower
    }

}
class Armor{
    lateinit var armorName: String
    var defensePower: Double = 0.0

    constructor(ArmorName: String, DefensePower: Double){
        this.armorName = ArmorName
        this.defensePower = DefensePower
    }
}

class Player{
    var playerCounter: Int = 1
    lateinit var name: String
    var healthPoints: Double = 100.0
    var damageGiven : Double = 0.0

    lateinit var armor: Armor
    lateinit var weapon: Weapon

    constructor(PlayerCounter: Int, Name: String)   {
        this.playerCounter = PlayerCounter
        this.name = Name
    }
    fun EquipWeapon(weapon: Weapon) {
        this.weapon = weapon
    }

    fun EquipArmor(armor: Armor){
        this.armor = armor
    }

    fun displayPlayer(){
        println("Player: $playerCounter")
        println("Name: $name")
        println("Health: $healthPoints")
        println("Weapon: ${weapon.weaponName} (${weapon.attackPower})")
        println("Armor: ${armor.armorName} (${armor.defensePower})")
    }

    fun displayBattlefield(){
        println("Player: $playerCounter")
        println("Name: $name")
        println("Health: $healthPoints")
    }

    fun Menyerang(opponent: Player){
        damageGiven = 0.0
    if (weapon.attackPower >= opponent.armor.defensePower){
        damageGiven = weapon.attackPower - opponent.armor.defensePower
        if (damageGiven > opponent.healthPoints){
            damageGiven = opponent.healthPoints
        } else{
            opponent.healthPoints = opponent.healthPoints - damageGiven
        }
    } else{
        opponent.healthPoints = opponent.healthPoints - 0
    }
    }
}
fun main(){
    var player1 = Player(1, "Morris")
    var sword = Weapon("Iron Sword", 13.0)
    var ironArmor = Armor("Iron Armor", 7.0)
    player1.EquipWeapon(sword)
    player1.EquipArmor(ironArmor)

    var player2 = Player(2, "Grok")
    var panah = Weapon("Bow", 17.0)
    var leatherArmor = Armor("Leather Armor", 4.0)
    player2.EquipWeapon(panah)
    player2.EquipArmor(leatherArmor)

    var kondisiBattlefield = true

    var roundCounter = 1
    while (kondisiBattlefield){

        player1.Menyerang(player2)
        println("Player 1 Menyerang Player 2 dengan damage ${player1.damageGiven}")
        player2.Menyerang(player1)
        println("Player 2 Menyerang Player 1 dengan damage ${player2.damageGiven}")

        println()
        println("Ronde $roundCounter telah berakhir berikut statistik kedua player: ")
        player1.displayBattlefield()
        println("===================")
        player2.displayBattlefield()
        println()
        roundCounter = roundCounter + 1

        if (player1.healthPoints == 0.0 || player2.healthPoints == 0.0){
            kondisiBattlefield = false
        }
    }
}