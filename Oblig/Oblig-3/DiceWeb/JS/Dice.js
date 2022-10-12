class Dice {
    #eyes;

    constructor(eyes = null){
        this.#eyes = eyes;
    }

    rollDice() {
        return Math.random() * (this.#eyes - 1) + 1;
    }
}