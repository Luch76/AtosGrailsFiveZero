// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.example.myapp.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.example.myapp.UserRole'
grails.plugin.springsecurity.authority.className = 'com.example.myapp.Role'

grails.plugin.springsecurity.rejectIfNoRule = true
grails.plugin.springsecurity.securityConfigType = 'InterceptUrlMap'

grails.plugin.springsecurity.interceptUrlMap = [
        [pattern: '/',               		access: ['permitAll']],
        [pattern: '/error',          		access: ['permitAll']],
        [pattern: '/index',          		access: ['permitAll']],
        [pattern: '/index.gsp',      		access: ['permitAll']],
        [pattern: '/public/**',      		access: ['permitAll']],
        [pattern: '/shutdown',       		access: ['permitAll']],
        [pattern: '/assets/**',      		access: ['permitAll']],
        [pattern: '/**/js/**',       		access: ['permitAll']],
        [pattern: '/**/css/**',      		access: ['permitAll']],
        [pattern: '/**/images/**',   		access: ['permitAll']],
        [pattern: '/**/favicon.ico', 		access: ['permitAll']],
        [pattern: '/api/login',				access: ['ROLE_ANONYMOUS']],
        [pattern: '/oauth/access_token',	access: ['ROLE_ANONYMOUS']],
        // [pattern: '/secure', 			access: ["hasAnyAuthority(${AuthorityTest.getCommaSeparatedAuthorities()})"]],
        //[pattern: '/secure', 				access: ['hasAnyAuthority(T(AuthorityTest).getCommaSeparatedAuthorities())']],
        [pattern: '/secure', 				access: ['hasAnyAuthority(T(nl.ciz.isa.security.Authorizations).allMedewerkerRoles)']],
]

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/assets/**',      filters: 'none'],
        [pattern: '/**/js/**',       filters: 'none'],
        [pattern: '/**/css/**',      filters: 'none'],
        [pattern: '/**/images/**',   filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
        [pattern: '/**',             filters: 'JOINED_FILTERS']
]