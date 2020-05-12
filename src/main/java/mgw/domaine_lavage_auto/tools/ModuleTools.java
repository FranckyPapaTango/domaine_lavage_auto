package mgw.domaine_lavage_auto.tools;



import com.google.common.hash.Hashing;

import class_util.Statut;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 *
 * @author smallwave
 */
public class ModuleTools {
   private static List<Statut> list1;//liste de statuts en contexte d'inscription
   private static List<Statut> list2;//liste de statuts en contexte de commande

    public static List<Statut> getList1() {
        list1=new ArrayList<>();//réinitialise, évite de surcharger la liste à chaque nouvel appel
        list1.add(new Statut(1, "Client"));
        list1.add(new Statut(2, "Admin   *(sous réserve)"));
        list1.add(new Statut(3, "Laveur/Micro Entreprenneur"));
        return list1;
    }

    public void setList1(List<Statut> list1) {
        this.list1 = list1;
    }

    public static List<Statut> getList2() {
        list2=new ArrayList<>();//réinitialise, évite de surcharger la liste à chaque nouvel appel
        list2.add(new Statut(1, "Client"));
        return list2;
    }

    public void setList2(List<Statut> list2) {
        this.list2 = list2;
    }
   
   
    /**
     * Cryptage / Hashage du mot de passe mdp
     * @param mdp
     * @return 
     */
    public static String hashGuava(String mdp){
    return Hashing.sha512().hashString(mdp, StandardCharsets.UTF_8).toString();
    }
    
    private static final String DATE_PATTERN="dd/MM/yyyy";
    private static final DateTimeFormatter DATE_FORMATTER=DateTimeFormatter.ofPattern(DATE_PATTERN);
    
    
    public static String capitalize(String word){
    if(isNullOrWithSpace(word)){
        return Character.toUpperCase(word.charAt(0))+word.substring(1).toLowerCase();
    } else {
    return null;
    }
    }
    
    
    /**
     * convertit une localdate en date
     * @param localDate
     * @return
     */
    public static Date asDate(LocalDate localDate){
    Instant instant=localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
    return Date.from(instant);
    }
    /**
     * convertit une localdateTime en date/hh/mm/ss
     * @param localDate
     * @return
     */
    public static Date asDateHMS(LocalDateTime localDateTime){    	
    	Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
    	return Date.from(instant);
        }
    
    
    
    public static LocalDate asLocalDate(Date date){
    Instant instant=date.toInstant();
    return instant.atZone(ZoneId.systemDefault()).toLocalDate();
    }
    
    
    
    
    public static LocalDate parse(String dateString){
    try {
        return LocalDate.parse(dateString, DATE_FORMATTER);
    }catch (DateTimeParseException e){    
    return null;
    }
    }
    
    public static boolean validDate(String dateString){
       return parse(dateString)!=null;
    }
    
    public static String format(LocalDate date){
    if(date==null){ return null;}
    return DATE_FORMATTER.format(date);
    }
    
    public static int calculAge(Date ddn){
    LocalDate naissance=asLocalDate(ddn);
    LocalDate maintenant=LocalDate.now();
    Period period=Period.between(naissance, maintenant);
    return period.getYears();
    }
    
    public static int calculAge(LocalDate ddn){
    LocalDate maintenant=LocalDate.now();
    Period period=Period.between(ddn, maintenant);
    return period.getYears();
    }
    
    public static boolean isNullOrWithSpace(String mot){
    return mot==null || mot.trim().length()==0;
    }


	

    
    
}