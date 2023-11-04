package pl.mazak.backend.startup;

import pl.mazak.backend.persistance.Role;

import java.util.List;

import static pl.mazak.backend.persistance.Role.*;
import static pl.mazak.backend.persistance.Role.SUPPORT;

record NewUserDTO(Long teamId, String summonerName, boolean captain, Role role) {
    NewUserDTO(Long teamId, String summonerName, Role role) {
        this(teamId, summonerName, false, role);
    }

    static List<NewUserDTO> getTournamentUsers() {
        return List.of(
                // TOPLANERS
                new NewUserDTO(4L, "kstdk", TOP),
                new NewUserDTO(6L, "grzmichυj", true, TOP),
                new NewUserDTO(7L, "JinnoO", TOP),
                new NewUserDTO(3L, "Songo L Kometa", TOP),
                new NewUserDTO(5L, "KuKIxKIn", true, TOP),
                new NewUserDTO(8L, "bartekbbb5", TOP),
                new NewUserDTO(1L, "aniel wiadro", TOP),
                new NewUserDTO(2L, "MlodyBomber", TOP),

//            // JUNGLERS
                new NewUserDTO(8L, "fjutek ciągutek", true, JUNGLE),
                new NewUserDTO(2L, "Balatatazar", JUNGLE),
                new NewUserDTO(3L, "ulome soldier", JUNGLE),
                new NewUserDTO(5L, "Samuel2285", JUNGLE),
                new NewUserDTO(1L, "Szypki Bartek", true, JUNGLE),
                new NewUserDTO(4L, "Nοt this One", true, JUNGLE),
                new NewUserDTO(7L, "GiveMeFreedom", JUNGLE),
                new NewUserDTO(6L, "GeraltThcWitcher", JUNGLE),

//            // MIDLANERS
                new NewUserDTO(6L, "grzegrzulek", MID),
                new NewUserDTO(4L, "Skopyr", MID),
                new NewUserDTO(8L, "syzyf ciężarek", MID),
                new NewUserDTO(3L, "SłodkaSarcia", true, MID),
                new NewUserDTO(5L, "Wyscigufka", MID),
                new NewUserDTO(2L, "Pain hate mad", true, MID),
                new NewUserDTO(7L, "wroobel1223", MID),
                new NewUserDTO(1L, "101messi101", MID),
//            // ADC's
                new NewUserDTO(3L, "syzyf 1v9", true, ADC),
                new NewUserDTO(7L, "Playboi Marcin", ADC),
                new NewUserDTO(6L, "Tymson", ADC),
                new NewUserDTO(8L, "TurboPtyś12", ADC),
                new NewUserDTO(4L, "Meneli Z Krosna", ADC),
                new NewUserDTO(2L, "Kress", ADC),
                new NewUserDTO(1L, "Ragnar Iothbrok", ADC),
                new NewUserDTO(5L, "ziutek17", ADC),

//            // Supports
                new NewUserDTO(4L, "Mishorinno", SUPPORT),
                new NewUserDTO(5L, "zmoczona cipcia", SUPPORT),
                new NewUserDTO(8L, "duży fjut", SUPPORT),
                new NewUserDTO(6L, "Szypki Jakub", SUPPORT),
                new NewUserDTO(3L, "Damciooo2004", SUPPORT),
                new NewUserDTO(7L, "maxdanielec", SUPPORT),
                new NewUserDTO(1L, "fiud", SUPPORT),
                new NewUserDTO(2L, "Szewcuu", SUPPORT));
    }

}
