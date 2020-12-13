using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Claims;
using System.Threading.Tasks;
using Client.Authentication;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.HttpsPolicy;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Client.Data;
using Client.Data.Impl;
using Client.Models;
using Microsoft.AspNetCore.Components.Authorization;
using Syncfusion.Blazor;

namespace Client
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        // For more information on how to configure your application, visit https://go.microsoft.com/fwlink/?LinkID=398940
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddRazorPages();
            services.AddServerSideBlazor();
            services.AddSyncfusionBlazor();
            services.AddScoped<IUserService, UserService>();
            services.AddSingleton<IServiceService, ServiceService>();
            services.AddSingleton<IBusinessService, BusinessService>();
            services.AddScoped<AuthenticationStateProvider, CustomAuthenticationStateProvider>();

            services.AddAuthorization(options =>
            {
                options.AddPolicy("HighLevelAdmin", a => a.RequireAuthenticatedUser().RequireAssertion(
                    context =>
                    {
                        Claim levelClaim = context.User.FindFirst(claim => claim.Type.Equals("Level"));
                        if (levelClaim == null) return false;
                        return int.Parse(levelClaim.Value) >= 5;
                    }));
                options.AddPolicy("BusinessOwner", a => a.RequireAuthenticatedUser().RequireClaim("Role", "BusinessOwner"));
            });
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            Syncfusion.Licensing.SyncfusionLicenseProvider.RegisterLicense(
                "MzMwMzgwQDMxMzgyZTMzMmUzMGlWSFo2S3NHQ21hNGl6V3Q3c2JDU3ZEWkREcXV2UWNOU0EvM1FscitwK3M9;MzMwMzgxQDMxMzgyZTMzMmUzMGxLajBPOStJTUc4SE1HRHNuN0RmbFhMS3ljY3BxSnNaaUZRSkxBMUFWMlk9;MzMwMzgyQDMxMzgyZTMzMmUzMFpJVFZldllQQ2cybVRjS3JGV1NmbGlBdDJxaitzT2NzTWZCUDU5UXFyd2s9;MzMwMzgzQDMxMzgyZTMzMmUzMElWVU1VMndWWTNTM2V6SzZsOHIzNDVsbVRtN2RDNEl5OHNKUWVFaFBXeG89;MzMwMzg0QDMxMzgyZTMzMmUzMFllbVJiM2FMRENkamRCU0dHR3NrMzVhVHJ2M09POUQzdWppS0UyTVFZdUk9");

            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            else
            {
                app.UseExceptionHandler("/Error");
                // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
                app.UseHsts();
            }

            app.UseHttpsRedirection();
            app.UseStaticFiles();

            app.UseRouting();

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapBlazorHub();
                endpoints.MapFallbackToPage("/_Host");
            });
        }
    }
}