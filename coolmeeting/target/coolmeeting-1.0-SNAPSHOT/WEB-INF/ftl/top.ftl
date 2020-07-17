<div class="page-header">
    <div class="header-banner">
        <img src="/images/header.png" alt="CoolMeeting"/>
    </div>
    <div class="header-title">
        欢迎访问Hello-Meeting会议管理系统
    </div>
    <div class="header-quicklink">

        <#if currentuser??>
            欢迎您，<strong>${currentuser.employeename!''}</strong>
            <a href="changepassword">[修改密码]</a>
        </#if>
    </div>
</div>