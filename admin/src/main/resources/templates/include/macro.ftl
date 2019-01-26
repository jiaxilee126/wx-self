<#-- 公共顶部 -->
<#macro header>
    <#include "/layout/head.ftl" />
</#macro>

<#macro sidebar>
    <#include "/layout/menu.ftl" />
</#macro>

<#-- 公共底部 -->
<#macro footer>
    <#include "/layout/footer.ftl"/>

    <#nested>

    </body>
</html>
</#macro>