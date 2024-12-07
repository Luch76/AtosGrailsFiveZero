package nl.ciz.isa.security

import org.springframework.security.core.GrantedAuthority

/**
 * User roles available in the application.
 */
enum ApplicationRole implements GrantedAuthority {

    BACK_OFFICE_MEDEWERKER('BackOffice Medewerker'),
    BACK_OFFICE_MEDEWERKER_BEROEP_BEZWAAR('BackOffice Medewerker beroep en Bezwaar'),
    INDICATIESTELLER('Indicatiesteller'),
    MEDISCH_ADVISEUR('Medisch Adviseur'),
    JURIDISCH_MEDEWERKER('Juridisch Medewerker'),
    KWALITEITSMEDEWERKER('Kwaliteits Medewerker'),
    TEAMMANAGER('Team Manager'),
    UNITMANGER('Unit Manager'),
    APPLICATIEBEHEERDER('Applicatie Beheerder'),
    ONDERZOEKER_FRAUDEBESTRIJDING('Onderzoeker fraudebestrijding'),
    SYSTEEMBEHEERDER('Systeem Beheerder'),
    SIP_TOETSER('SIP Toetser'),
    TOETSER('Toetser'),
    INZAGE('Inzage'),
    RELATIEBEHEERDER('Relatiebeheerder'),
    UZI_PASS_USER('UZIpassUser'),
    BASIS('Basis'),
    BASIS_WEL_ID('Basis wel Id'),
    BASIS_PLUS_WEL_ID('BasisPlus wel Id'),
    BASIS_PLUS('Basis Plus'),
    CIZ_BASIS('CIZ Basis'),
    VOLLEDIG('Volledig'),
    HUNTINGTON('Huntington'),
    SGLVG('SGLVG'),
    ZG('ZG'),
    ERAI1('ERAI1'),
    ERAI4('ERAI4'),
    ERAI5('ERAI5'),
    ERAI6('ERAI6'),
    ERAI7('ERAI7'),
    BJZ('BJZbasis'),
    TERUGMELDING('Terugmelding'),
    BEOORDELAAR('Beoordelaar'),
    ONDERZOEKER('Onderzoeker'),
    MEDISCH_ADVISEUR_WLZ('Medisch Adviseur WLZ'),
    TEAMCOACH('Teamcoach'),
    REGIO_MANAGER('Regiomanager'),
    MEDEWERKER_ADMINISTRATIEVE_ONDERSTEUNING('Medewerker Administratieve Ondersteuning'),
    JURIST('Jurist'),
    MEDEWERKER_BUK('Medewerker BUK'),
    JURIDISCH_ADVISEUR_WZD('Juridisch adviseur Wzd'),
    TEAMCOACH_BUK('Teamcoach BUK'),
    ADVISEUR('Adviseur'),
    ADVISEUR_PROCESBEHEERSING('Adviseur Procesbeheersing'),
    BI_SPECIALIST_ANALYSE_EN_ADVIES('BI-Specialist Analyse en Advies'),
    RESEARCHER('Researcher'),
    ROLE_ADMIN('ROLE_ADMIN'),
    ADMIN('ADMIN')

    final String name

    public static final List showPopupBasedOnRole = Arrays.asList(MEDEWERKER_ADMINISTRATIEVE_ONDERSTEUNING, BEOORDELAAR,ONDERZOEKER, MEDISCH_ADVISEUR_WLZ, JURIDISCH_MEDEWERKER, MEDEWERKER_BUK, JURIDISCH_ADVISEUR_WZD)

    public static final List alwaysShowPopup = Arrays.asList(TEAMCOACH, APPLICATIEBEHEERDER, INZAGE)

    ApplicationRole(final String name) {
        this.name = name
    }

    String getAuthority() {
        name
    }

    /**
     * Get ApplicationRole based on name.
     *
     * @param name Name of role.
     * @return ApplicationRole for given name.
     */
    static List<ApplicationRole> fromName(final String name) {
        final roles = [name]
        roles.collect { roleName ->
            findByName(roleName)
        }
    }

    private static ApplicationRole findByName(final String name) {
        values().find { name == it.name }
    }

    String toString() {
        name
    }
}
