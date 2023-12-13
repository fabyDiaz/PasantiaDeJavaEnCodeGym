package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "JuegoDelGatoCodeGym_bot";
    public static final String TOKEN = "6490807588:AAHKqabBlPSGXGobFrONVX1IzDj7cbJdTzk";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí

        if(getMessageText().equals("/start")){
            sendTextMessageAsync("*Bienvenido/a al chatBot gatuno*");
        }
        if(getMessageText().toLowerCase().contains("hola")){
            sendTextMessageAsync("Hola, ¿Cuál es tu nombre?");
        }

       if(getMessageText().toLowerCase().contains("mi nombre es")||getMessageText().toLowerCase().contains("me llamo")||getMessageText().toLowerCase().contains("soy")){
            sendTextMessageAsync("Encantado de conocerte, soy *Gato*");
        }
        if(getMessageText().toLowerCase().contains("gracias")){
            sendTextMessageAsync("Estoy aquí para lo que necesites");
        }
        if(getMessageText().toLowerCase().contains("adios")||getMessageText().toLowerCase().contains("chao")||getMessageText().toLowerCase().contains("nos vemos")){
            sendTextMessageAsync("*Hasta la próxima!*");
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}