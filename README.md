# Chat bot

This Slack bot is created just for Java learning purposes. 
Currently it only can post a poll "Where to go for lunch"
Feel free to use it if you suddenly want to :)

## Installation

- Clone repository
- Copy `config.sample.properties` file into `config.properties`
- Set correct configuration inside of copied properties file
- Run `./gradlew build`
- Then `./gradlew run`
- Now server is up and running
- Don't forget to invite robot to the channel :)

Also you can set 2 console params when running the bot.

- `args[0]` is token
- `args[1]` is default channel

This params have higher priority.

## Plans

- Add possibility to use Database to store poll lists
- Update list dynamically from chat
- Add any other interesting behaviours

## Contributions
All contributions and help are highly appreciated. I want to learn Java and will be grateful for any help. 
Make your Pull Requests to the master branch.

## Licence
This software distributed under MIT licence and provided AS IS.