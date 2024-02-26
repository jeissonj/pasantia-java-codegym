package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "CodeGymGatoBot_bot";
    public static final String TOKEN = "7147202898:AAGJrHikRZ1hMFxvHtZPjzig1cwjdS3wEnA";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí
        if(getMessageText().equals("/start")){
            sendTextMessageAsync("Hola, futuro programador Jeisson");
        }
        if(getMessageText().contains("hola")){
            sendTextMessageAsync("Hola ¿Cuál es tu nombre?");
        }
        if(getMessageText().contains("mi nombre es")){
            sendTextMessageAsync("Un placer yo soy Gato");
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}