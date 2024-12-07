package nl.ciz.isa.security


import static nl.ciz.isa.security.ApplicationRole.*;
import org.springframework.security.core.GrantedAuthority

final class Authorizations {

    static String getAllRoles() {
        rolesToString(getAllInterneMedewerkerRoles())
    }

    static String getAllMedewerkerRoles() {
        rolesToString(getAllInterneMedewerkerRoles())
    }
    static String getAllLuchRoles() {
        rolesToString(getAllInterneMedewerkerRoles())
    }
    static String getAllMedewerkersExceptLimitedRoles(){
        rolesToString([APPLICATIEBEHEERDER, SYSTEEMBEHEERDER, MEDEWERKER_ADMINISTRATIEVE_ONDERSTEUNING, BEOORDELAAR,
                       ONDERZOEKER, MEDISCH_ADVISEUR_WLZ, JURIDISCH_MEDEWERKER, TEAMCOACH,
                       MEDEWERKER_BUK, JURIDISCH_ADVISEUR_WZD, TEAMCOACH_BUK, ADVISEUR_PROCESBEHEERSING])
    }

    private static List getAllInterneMedewerkerRoles() {
        [BACK_OFFICE_MEDEWERKER, INDICATIESTELLER, MEDISCH_ADVISEUR, KWALITEITSMEDEWERKER, JURIDISCH_MEDEWERKER,
         TEAMMANAGER, UNITMANGER, TOETSER, SIP_TOETSER, INZAGE, ONDERZOEKER_FRAUDEBESTRIJDING,
         APPLICATIEBEHEERDER, SYSTEEMBEHEERDER, BACK_OFFICE_MEDEWERKER_BEROEP_BEZWAAR,
         BEOORDELAAR, ONDERZOEKER, MEDISCH_ADVISEUR_WLZ, TEAMCOACH, MEDEWERKER_ADMINISTRATIEVE_ONDERSTEUNING,
         MEDEWERKER_BUK, JURIDISCH_ADVISEUR_WZD, TEAMCOACH_BUK,
         ADVISEUR, ADVISEUR_PROCESBEHEERSING, BI_SPECIALIST_ANALYSE_EN_ADVIES, RESEARCHER, ROLE_ADMIN]
    }

    static List getInterneMedewerkerRolesAllowedSip() {
        [BACK_OFFICE_MEDEWERKER, JURIDISCH_MEDEWERKER, INDICATIESTELLER,
         KWALITEITSMEDEWERKER, TEAMMANAGER, UNITMANGER, SIP_TOETSER, TOETSER, BACK_OFFICE_MEDEWERKER_BEROEP_BEZWAAR]
    }

    static String getWerklijstenRoles() {
        rolesToString(allInterneMedewerkerRoles - INZAGE - ONDERZOEKER_FRAUDEBESTRIJDING - ADVISEUR_PROCESBEHEERSING - BI_SPECIALIST_ANALYSE_EN_ADVIES - RESEARCHER - ADVISEUR)
    }

    static String getRolesForChangingColor(){
        rolesToString(allInterneMedewerkerRoles - INZAGE - ONDERZOEKER_FRAUDEBESTRIJDING - BI_SPECIALIST_ANALYSE_EN_ADVIES - RESEARCHER - ADVISEUR)
    }

    static String getTaakToewijzenRoles() {
        rolesToString(allInterneMedewerkerRoles - INZAGE - ONDERZOEKER_FRAUDEBESTRIJDING - ADVISEUR_PROCESBEHEERSING - BI_SPECIALIST_ANALYSE_EN_ADVIES - RESEARCHER - ADVISEUR)
    }

    static String getTaakRoles() {
        rolesToString(allInterneMedewerkerRoles - INZAGE - ONDERZOEKER_FRAUDEBESTRIJDING)
    }

    static String getBukAanUitRoles() {
        rolesToString(allInterneMedewerkerRoles - REGIO_MANAGER - ONDERZOEKER_FRAUDEBESTRIJDING - ONDERZOEKER - JURIDISCH_ADVISEUR_WZD - TEAMCOACH_BUK - ADVISEUR_PROCESBEHEERSING - TEAMCOACH)
    }

    static String getGenereerTrajectBriefRoles() {
        rolesToString(allInterneMedewerkerRoles - INZAGE - ONDERZOEKER_FRAUDEBESTRIJDING - ADVISEUR -  BI_SPECIALIST_ANALYSE_EN_ADVIES - ADVISEUR_PROCESBEHEERSING - RESEARCHER)
    }

    static String getUploadDocumentTrajectRoles() {
        rolesToString(allInterneMedewerkerRoles - TEAMCOACH - ADVISEUR -  BI_SPECIALIST_ANALYSE_EN_ADVIES - ADVISEUR_PROCESBEHEERSING - RESEARCHER )
    }

    static String getTrajectKenmerkenTrajectRoles() {
        rolesToString(allInterneMedewerkerRoles - TEAMCOACH - ADVISEUR -  BI_SPECIALIST_ANALYSE_EN_ADVIES - ADVISEUR_PROCESBEHEERSING - RESEARCHER )
    }

    static String getRegistreerKlachtTrajectRoles() {
        rolesToString(allInterneMedewerkerRoles - ADVISEUR -  BI_SPECIALIST_ANALYSE_EN_ADVIES - ADVISEUR_PROCESBEHEERSING - RESEARCHER )
    }

    static String getRegistreerTulOpnameTrajectRoles() {
        rolesToString(allInterneMedewerkerRoles - TEAMCOACH - ADVISEUR -  BI_SPECIALIST_ANALYSE_EN_ADVIES - ADVISEUR_PROCESBEHEERSING - RESEARCHER )
    }

    static String getFraudeDatabankRoles() {
        rolesToString(allInterneMedewerkerRoles - INZAGE - REGIO_MANAGER - ADVISEUR_PROCESBEHEERSING - BI_SPECIALIST_ANALYSE_EN_ADVIES - RESEARCHER - ADVISEUR)
    }

    static String getManagementRoles() {
        rolesToString([TEAMMANAGER, UNITMANGER, APPLICATIEBEHEERDER, SYSTEEMBEHEERDER, TEAMCOACH, TEAMCOACH_BUK])
    }

    static String getResterendeDagenRapportageRoles(){
        getManagementRoles()+','+ rolesToString([JURIDISCH_MEDEWERKER, JURIDISCH_ADVISEUR_WZD])
    }

    static String[] getBeheerRoles() {
        String s;
        //s = rolesToString([APPLICATIEBEHEERDER, SYSTEEMBEHEERDER, ROLE_ADMIN, ADMIN]);

        def authorities = [ROLE_ADMIN, APPLICATIEBEHEERDER];

        return authorities;

        //return authorities.collect { it.toString() }.join(", ");

        //s = "\"" + s + "\"";
        //return s;
    }

    static String getLuchRoles() {
        String s = rolesToString([APPLICATIEBEHEERDER, SYSTEEMBEHEERDER]);
        return s;
    }

    static String getApplicatieBeheerRole() {
        rolesToString([APPLICATIEBEHEERDER])
    }

    static String getBukAdviezenPrinten() {
        rolesToString([MEDEWERKER_ADMINISTRATIEVE_ONDERSTEUNING, APPLICATIEBEHEERDER, TEAMCOACH, TEAMCOACH_BUK])
    }

    static String getToetserRoles() {
        rolesToString([TOETSER, SIP_TOETSER])
    }

    static boolean getNoAccess(){
        false
    }

    //Added for the story TL-8831 A7-1092
    //For Primair Process
    static String getBatchPrintenRoles(){
        rolesToString([APPLICATIEBEHEERDER, SYSTEEMBEHEERDER, MEDEWERKER_ADMINISTRATIEVE_ONDERSTEUNING, TEAMCOACH])
    }

    static String getMijnTenaamstellingRoles(){
        rolesToString([allInterneMedewerkerRoles - INZAGE - ONDERZOEKER_FRAUDEBESTRIJDING - ADVISEUR_PROCESBEHEERSING - BI_SPECIALIST_ANALYSE_EN_ADVIES - RESEARCHER - ADVISEUR])
    }

    static String getZelfaanmeldingRoles(){
        rolesToString([TEAMMANAGER, UNITMANGER, APPLICATIEBEHEERDER, SYSTEEMBEHEERDER, TEAMCOACH, MEDEWERKER_ADMINISTRATIEVE_ONDERSTEUNING, ONDERZOEKER_FRAUDEBESTRIJDING])
    }

    static String getSteekproefToetsingRoles(){
        rolesToString([APPLICATIEBEHEERDER, ADVISEUR_PROCESBEHEERSING])
    }

    static String getPersoonlijkepaginaRoles(){
        rolesToString([MEDEWERKER_ADMINISTRATIEVE_ONDERSTEUNING, BEOORDELAAR, ONDERZOEKER, MEDISCH_ADVISEUR, MEDISCH_ADVISEUR_WLZ])
    }

    static String getTeampaginaRoles(){
        rolesToString([MEDEWERKER_ADMINISTRATIEVE_ONDERSTEUNING, BEOORDELAAR, ONDERZOEKER, MEDISCH_ADVISEUR, MEDISCH_ADVISEUR_WLZ])
    }

    static String getWerkvoorraadRoles(){
        getAllMedewerkersExceptLimitedRoles() - rolesToString([ONDERZOEKER_FRAUDEBESTRIJDING])
    }

    /*   static String getPrimairProcessRoles(){
           rolesToString(allInterneMedewerkerRoles - REGIO_MANAGER)
       }*/

    //For Management

    static String getWerkvoorraadManagementRoles(){
        rolesToString([TEAMCOACH, REGIO_MANAGER, APPLICATIEBEHEERDER, SYSTEEMBEHEERDER, TEAMCOACH_BUK])
    }
    static String getReviewToetsingspercentagesRoles(){
        rolesToString([TEAMCOACH, REGIO_MANAGER, APPLICATIEBEHEERDER, SYSTEEMBEHEERDER, TEAMCOACH_BUK])
    }
    //Till here

    static String getWzdBerichtenRoles(){
        rolesToString([MEDEWERKER_ADMINISTRATIEVE_ONDERSTEUNING, TEAMCOACH, APPLICATIEBEHEERDER])
    }

    static String getDigitalePostRoles() {
        rolesToString([MEDEWERKER_ADMINISTRATIEVE_ONDERSTEUNING, TEAMCOACH, APPLICATIEBEHEERDER])
    }

    static String getWwmUitwisselingZonderBsnRoles() {
        rolesToString([JURIDISCH_ADVISEUR_WZD, ADVISEUR, APPLICATIEBEHEERDER])
    }

    static String rolesToString(final Collection<GrantedAuthority> roles) {
        rolesToArray(roles).join(',')
    }

    static String roleToString(final GrantedAuthority role) {
        rolesToString([role])
    }

    private static String[] rolesToArray(final Collection<GrantedAuthority> roles) {
        roles.authority as String[]
    }

    static String getBasisRoles() {
        rolesToString([BASIS_WEL_ID, BASIS_PLUS_WEL_ID])
    }

    static List<ApplicationRole> getAfspraakRoles() {
        [ONDERZOEKER, JURIDISCH_MEDEWERKER, TEAMCOACH, REGIO_MANAGER, APPLICATIEBEHEERDER, BEOORDELAAR]
    }

    static List<ApplicationRole> getRolesForBeroepAndBezwaar() {
        [JURIDISCH_MEDEWERKER, TEAMCOACH, REGIO_MANAGER, APPLICATIEBEHEERDER]
    }

    static String getInzageAndFraudRoles() {
        rolesToString([INZAGE, ONDERZOEKER_FRAUDEBESTRIJDING])
    }

    static String getFraudeOnderzoekAndBeheerFraudeRoles(){
        rolesToString([ONDERZOEKER_FRAUDEBESTRIJDING, APPLICATIEBEHEERDER])
    }

    static String getNewAanvraagRoles() {
        rolesToString(allInterneMedewerkerRoles - INZAGE - ONDERZOEKER_FRAUDEBESTRIJDING - TEAMCOACH - ADVISEUR - ADVISEUR_PROCESBEHEERSING - BI_SPECIALIST_ANALYSE_EN_ADVIES - RESEARCHER)
    }

    static String getTrajectNotitieAndContactMomentenRoles() {
        rolesToString(allInterneMedewerkerRoles - INZAGE - TEAMCOACH - ADVISEUR_PROCESBEHEERSING - BI_SPECIALIST_ANALYSE_EN_ADVIES - RESEARCHER)
    }

    static String getClientNotitieRoles() {
        rolesToString(allInterneMedewerkerRoles - ADVISEUR_PROCESBEHEERSING - BI_SPECIALIST_ANALYSE_EN_ADVIES - RESEARCHER)
    }

}
