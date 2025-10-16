package com.example.Cold_Emailing.utils;

import java.util.Set;

public final class NameExtractor {
    private static final Set<String> BLOCKED = Set.of(
            "career", "careers", "info", "support", "admin", "no-reply", "noreply", "hr",
            "jobs", "team", "contact", "help", "service", "feedback");

    private NameExtractor() {
    }

    public static String extractName(String email) {
        if (email == null || !email.contains("@"))
            return "";
        String prefix = email.split("@")[0];
        if (BLOCKED.contains(prefix.toLowerCase()))
            return "";
        prefix = prefix.replace(".", " ").replace("_", " ");
        String[] parts = prefix.split(" ");
        if (parts.length == 0 || parts[0].isBlank())
            return "";
        String raw = parts[0];
        return Character.toUpperCase(raw.charAt(0)) + raw.substring(1);
    }

    public static String extractCompany(String email) {
        if (email == null || !email.contains("@"))
            return null;
        String domain = email.split("@")[1].toLowerCase();
        String[] parts = domain.split("\\.");
        if (parts.length < 2)
            return null;
        String company = parts[parts.length - 2];
        if (company.isBlank())
            return null;
        return Character.toUpperCase(company.charAt(0)) + company.substring(1);
    }
}
